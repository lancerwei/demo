package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import user.UserInfo;

public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String card = (String) request.getAttribute("card");
		System.out.println(card);
		String balance = request.getParameter("balance");
		System.out.println(balance);
		UserInfoDao dao = new UserInfoDao();
		try {
			UserInfo user = dao.findByCard1(card);
			user.setBalance(Double.parseDouble(balance));
			dao.modify(user);
			response.sendRedirect("main-page.html");
			
//			out.println("<form action='' method='post'>");
//			out.println("卡号：<input name='card' value='"+user.getCard()+"'/><br/>");
//			out.println("卡主：<input name='username' value='"+user.getUsername()+"'/><br/>");
//			out.println("卡内余额：<input name='balance' value='"+user.getBalance()+"'/><br/>");
//			out.println("<input type='hidden' name='card' value='"+user.getCard()+"'/>");
//			out.println("</form>"); 
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后再试！");
			throw new RuntimeException(e);
		}
	}

}
