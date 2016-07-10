package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

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
import model.Section;

/**
 * Servlet implementation class searchCourseServlet
 */
@WebServlet("/searchCourseServlet")
public class searchCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCourseServlet() {
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
		
		 CourseDao courseDao =  DaoFactory.createCourseDao();
			HashMap<String,Course> courses = new HashMap<String, Course>();
		 courses= courseDao.findAll();
			ArrayList<Course> cous = new ArrayList<Course>();
			Set<HashMap.Entry<String, Course>> set=courses.entrySet();    
		
			for (Iterator<Entry<String, Course>> iterator = set.iterator(); iterator.hasNext();) {  
				HashMap.Entry<String, Course> entry = (HashMap.Entry<String, Course>) iterator.next();  
              
               Course value=entry.getValue(); 
               cous.add(value);
             /*  Collection<Course> prerequisite  =  value.getPrerequisites();
               
                for (Course pre : prerequisite) {
                String  cNo=pre.getCourseNo();
                CNo.add(cNo);
               */
                }
            
		    request.setAttribute("courses", cous);
		  request.getRequestDispatcher("pages/showcourse.jsp").forward(request,response);
	
	}

}
