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

		//����ͳһ�������
		request.setCharacterEncoding("utf-8");
		//��ȡ�û���������
		String username=request.getParameter("userAccount");
		String usercheckcode=request.getParameter("checkcode");
		//��ȡϵͳ��������֤��
		HttpSession session=request.getSession();
		String servercheckcode=(String)session.getAttribute("checkcode");
		//�������ݿ����Ӻ�ִ�ж���
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//��ʾ��¼��Ϣ
		String login_msg="";
		//ͨ��Servlet�е�session.setAttribute����������ǰ�û��ĵ�¼��Ϣ���û���������session��
		session.setAttribute("userAccount", username);
		
		try {
			if(username.equals(null) || username=="") {  
				login_msg="�������ֻ��ţ�";
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
						login_msg="��֤��������������룡";
						request.setAttribute("checkcode_msg", login_msg);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}else {
						request.getRequestDispatcher("memo.jsp").forward(request, response);
					}
				}else {
					login_msg="���û�δע�ᣬ����ע�ᣡ";
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
