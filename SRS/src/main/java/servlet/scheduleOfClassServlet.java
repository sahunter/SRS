package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.DaoFactory;
import dao.SectionDao;
import dao.UserDao;
import model.Course;
import model.Section;
import model.TranscriptEntry;
import service.ScheduleOfClassesService;


/**
 * Servlet implementation class scheduleOfClassServlet
 */
@WebServlet("/scheduleOfClassServlet")
public class scheduleOfClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scheduleOfClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }   
	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String  semester=request.getParameter("semester");
		 SectionDao sectionDao =  DaoFactory.createSectionDao();
		 ArrayList<Section> secs = new ArrayList<Section>();
		 ArrayList<String> keys = new ArrayList<String>();
        HashMap<String, Section> sections = new HashMap<String, Section>();
		  sections     = sectionDao.findBySemester(semester);
		  Set<Entry<String, Section>> set=sections.entrySet();    
          for (Iterator<Entry<String, Section>> iterator = set.iterator(); iterator.hasNext();) {  
         	 Entry<String, Section> entry =iterator.next();  
                String key=entry.getKey();  
                 Section value=entry.getValue(); 
                 secs.add(value);
                 keys.add(key);    
          }
		    request.setAttribute("secs", secs);
		    request.setAttribute("keys", keys);
			request.getRequestDispatcher("pages/enrollcourse.jsp").forward(request,response);
}
}
