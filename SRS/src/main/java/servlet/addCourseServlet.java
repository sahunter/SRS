package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.DaoFactory;
import dao.PersonDao;
import model.Course;
import model.Professor;

/**
 * Servlet implementation class addCourse
 */
@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCourseServlet() {
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
		String[] course=request.getParameterValues("add3");
		String courseNo=course[0];
		String courseName=course[1];
		String credits=course[2];
		Course course1 =new Course(courseNo, courseName, Double.valueOf(credits));
		 CourseDao courseDao =  DaoFactory.createCourseDao();
		 courseDao.addCourse(course1);
		 response.sendRedirect("pages/courseinformationmanagement.jsp");
		
		
	}

}
