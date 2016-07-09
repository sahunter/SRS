package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.DaoFactory;
import dao.SectionDao;
import model.Course;
import model.Section;

/**
 * Servlet implementation class addSectionServlet
 */
@WebServlet("/addSectionServlet")
public class addSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSectionServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		String[] section=request.getParameterValues("add3");
		String fullSectionNo=section[0];
		String sectionNo=section[1];
		String dayOfWeek=section[2];
		String timeOfDay=section[3];
		String room=section[4];
		String seatingCapacity=section[5];
		String representedCourse=section[6];
		Section section1 =new Section(Integer.parseInt(sectionNo), dayOfWeek.charAt(0), timeOfDay,null,room,Integer.parseInt(seatingCapacity));
		SectionDao sectionDao =  DaoFactory.createSectionDao();
		sectionDao.addSection(fullSectionNo,section1,representedCourse);
		 response.sendRedirect("pages/sectioninformationmanagement.jsp");
		
	}

}
