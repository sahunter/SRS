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
 * Servlet implementation class updateCourseServlet
 */
@WebServlet("/updateCourseServlet")
public class updateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCourseServlet() {
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
		String[] course=request.getParameterValues("add3");
		String courseNo=course[0];
		String courseName=course[1];
		String credits=course[2];
		Course course1 =new Course(courseNo, courseName, Double.valueOf(credits));
		 CourseDao courseDao =  DaoFactory.createCourseDao();
		 courseDao.updateCourse(course1);
		  response.sendRedirect("pages/courseinformationmanagement.jsp");	
	}

}
