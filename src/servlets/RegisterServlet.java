package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User_Info;
import dao.Register_DAO;
import dbc.JdbcUtil;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//设置统一编码编码
		request.setCharacterEncoding("utf-8");
		//获取用户名和密码
		String username=request.getParameter("userAccount");
		String usercheckcode=request.getParameter("checkcode");
		//获取系统产生的验证码
		HttpSession session=request.getSession();
		String servercheckcode=(String)session.getAttribute("checkcode");
		//创建数据库连接和执行对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//提示注册信息
		String register_msg="";
		//创建对象
		User_Info user=new User_Info(username);
		Register_DAO addRegister=new Register_DAO();
		
		try {
			if(username==null || username=="") {  
				register_msg="请输入手机号！";
				request.setAttribute("userName_msg", register_msg);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else {
				conn=JdbcUtil.getConnection();
				String checkRegisterSql="select user_account from user_info where user_account=?";
				ps=conn.prepareStatement(checkRegisterSql);
				ps.setString(1, username);
				rs=ps.executeQuery();
				if(!rs.next()) {
					if(!servercheckcode.equalsIgnoreCase(usercheckcode)) {
						register_msg="验证码错误，请重新输入！";
						request.setAttribute("checkcode_msg", register_msg);
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}else {
						addRegister.addRegisterInfo(user);
						request.getRequestDispatcher("registerSuccess.html").forward(request, response);
					}
				}else {
					register_msg="该手机号已注册，请直接登录";
					request.setAttribute("userName_msg", register_msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.free(rs, ps, conn);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
