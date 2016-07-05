package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.User;
import service.loginService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
		String relatedtype = request.getParameter("checked");
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    request.getSession().setAttribute("username", username);
	    request.getSession().setAttribute("password", password);
	    String page = null;
		if (loginService.checklogin(username,password)){
			/*if(relatedtype=="Student"){
	    	  page ="pages/scheduleofclasses.jsp";
			}else{
				page ="pages/scheduleofclasses.jsp";
			}*/
			 page ="pages/scheduleofclasses.jsp";
	    }else{	   
	    	page ="pages/login.jsp";}

	    response.sendRedirect(page);
	}

}
