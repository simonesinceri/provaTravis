package logic.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.LoginBeanWeb;


/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		String beanString = "beanLog";
		LoginBeanWeb bean = (LoginBeanWeb)session.getAttribute(beanString);
		
		RequestDispatcher view = request.getRequestDispatcher("profileView.jsp");
		
		
		if(bean.getUserWebLog() != null) {  
			session.setAttribute("userLog", null);
			session.setAttribute(beanString, null);
			view.forward(request, response);
		}else {
			session.setAttribute("ownerLog", null);
			session.setAttribute(beanString,bean);
			view.forward(request, response);
		}
		
	}

}
