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

import dbc.JdbcUtil;

public class LoginServlet extends HttpServlet {

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
		//提示登录信息
		String login_msg="";
		//通过Servlet中的session.setAttribute方法，将当前用户的登录信息即用户名保存在session中
		session.setAttribute("userAccount", username);
		
		try {
			if(username.equals(null) || username=="") {  
				login_msg="请输入手机号！";
				request.setAttribute("userName_msg", login_msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				conn=JdbcUtil.getConnection();
				String checkLoginSql="select user_account from user_info where user_account=?";
				ps=conn.prepareStatement(checkLoginSql);
				ps.setString(1,username);
				rs=ps.executeQuery();
				if(rs.next()) {
					if(!servercheckcode.equalsIgnoreCase(usercheckcode)) {
						login_msg="验证码错误，请重新输入！";
						request.setAttribute("checkcode_msg", login_msg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}else {
						request.getRequestDispatcher("memo.jsp").forward(request, response);
					}
				}else {
					login_msg="该用户未注册，请先注册！";
					request.setAttribute("userName_msg", login_msg);
					request.getRequestDispatcher("register.jsp").forward(request, response);
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
