package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PersonDao;
import model.Professor;

/**
 * Servlet implementation class addprofessor
 */
@WebServlet("/addProfessorServlet")
public class addProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProfessorServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] professor=request.getParameterValues("add");
		String type=professor[0];
		String ssn=professor[1];
		String name=professor[2];
		String title=professor[3];
		String dept=professor[4];
		Professor professor1 =new Professor(ssn, name, title, dept);
		 PersonDao personDao =  DaoFactory.createPersonDao();
		personDao.addProfessor(type,professor1);
		  response.sendRedirect("pages/professorinformationmanagement.jsp");
	}

}
