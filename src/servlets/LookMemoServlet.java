package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Memo_DAO;

import beans.Memo_User;

public class LookMemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Memo_User memo_user=new Memo_User();
		//通过Servlet中的request.getSession()方法获取登录页面的当前登录账号
		String userAccount=(String) request.getSession().getAttribute("userAccount");
		memo_user.setUser_account(userAccount);
		Memo_DAO memo=new Memo_DAO();
		try {
			List<Memo_User> memoList=new ArrayList<Memo_User>();
			memoList=memo.lookMemoInfo(memo_user);
			request.setAttribute("memo_result", memoList);
			request.getRequestDispatcher("lookmemo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
