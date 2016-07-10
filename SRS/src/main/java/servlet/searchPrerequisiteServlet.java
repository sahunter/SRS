package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDao;
import dao.DaoFactory;
import model.Course;

/**
 * Servlet implementation class searchPrerequisiteServlet
 */
@WebServlet("/searchPrerequisiteServlet")
public class searchPrerequisiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchPrerequisiteServlet() {
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
		String course = request.getParameter("course");
		 CourseDao courseDao =  DaoFactory.createCourseDao();
		HashMap<String,Course> prerequisites = new HashMap<String, Course>();
		 prerequisites= courseDao.findPrerequisiteByCourse(course);
		 ArrayList<Course> pre = new ArrayList<Course>();
			Set<HashMap.Entry<String, Course>> set=prerequisites.entrySet();    
			for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
				HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
           
            Course value=entry.getValue(); 
            pre.add(value);
             }
        
         
		    request.setAttribute("prerequisite", pre);
		  request.getRequestDispatcher("pages/showprerequisite.jsp").forward(request,response);
	
	}

}
