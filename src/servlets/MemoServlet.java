package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Memo_User;
import dao.Memo_DAO;
public class MemoServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		String content=request.getParameter("content");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String note=request.getParameter("note");
		String onetime=request.getParameter("onetime");
		Memo_User memo_user=new Memo_User();
		//通过Servlet中的request.getSession()方法获取登录页面的当前登录账号
		String userAccount=(String) request.getSession().getAttribute("userAccount");
		
		memo_user.setUser_account(userAccount);
		memo_user.setMemo_content(content);
		memo_user.setMemo_account(account);
		memo_user.setMemo_password(password);
		memo_user.setMemo_note(note);
		memo_user.setMemo_date(onetime);
		Memo_DAO memo=new Memo_DAO();
		try {
			memo.addMemoInfo(memo_user);
			String memo_msg="保存成功！";
			request.setAttribute("save_msg", memo_msg);
			request.getRequestDispatcher("memo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
