package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.DaoFactory;
import model.Course;

/**
 * Servlet implementation class addPrerequisiteServlet
 */
@WebServlet("/addPrerequisiteServlet")
public class addPrerequisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPrerequisiteServlet() {
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
		String[] prerequisite=request.getParameterValues("add3");
		String ID=prerequisite[0];
		String presentcourse=prerequisite[1];
		String prerequisite1=prerequisite[2];
		 CourseDao courseDao =  DaoFactory.createCourseDao();
		 courseDao.addPrerequisite(ID,presentcourse,prerequisite1);
		 response.sendRedirect("pages/prerequisiteinformationmanagement.jsp");
		
	}

}
