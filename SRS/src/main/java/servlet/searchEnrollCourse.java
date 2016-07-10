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

import dao.DaoFactory;
import dao.SectionDao;
import dao.TranscriptDao;
import model.Section;
import model.TranscriptEntry;
import model.User;

/**
 * Servlet implementation class searchEnrollCourse
 */
@WebServlet("/searchEnrollCourse")
public class searchEnrollCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchEnrollCourse() {
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
		 String username=(String) request.getSession().getAttribute("username");
		 String password=(String)request.getSession().getAttribute("password");
		    
		    User  user=new User();
			user.setUserName(username);
			user.setPassWord(password);
			 SectionDao sectionDao =  DaoFactory.createSectionDao();
			 ArrayList<Section> secs = new ArrayList<Section>();
			 ArrayList<String> keys = new ArrayList<String>();
	        HashMap<String, Section> sections = new HashMap<String, Section>();
			  sections     = sectionDao.findByName(user);
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
				request.getRequestDispatcher("pages/showenrollcourse.jsp").forward(request,response);
	}
}
