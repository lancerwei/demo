package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.UserInfoDao;
import user.UserInfo;

public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//读取用户名和密码
		String card = request.getParameter("card");
		String password = request.getParameter("password");
		System.out.println(card+","+password);
		//查询数据库
		UserInfoDao dao = new UserInfoDao();
		try {
			UserInfo user = dao.findByCard1(card);
			System.out.println(user);
			if (user!=null && password.equals(user.getPassword())) {
				//登录成功
				System.out.println("真的成功了？");
				double balance = user.getBalance();
				
				request.setAttribute("card",card);
				request.setAttribute("balance", balance);
				request.getRequestDispatcher("main-page.html").forward(request, response);
				//response.sendRedirect("main-page.html");
			}else {
				//登录失败
				request.setAttribute("login_failed", "用户名或密码错误");
				request.getRequestDispatcher("load.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
