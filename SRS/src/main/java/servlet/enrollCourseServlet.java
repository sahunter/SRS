package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;

import dao.DaoFactory;
import dao.PersonDao;
import dao.SectionDao;
import dao.TranscriptDao;
import model.EnrollmentStatus;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import model.User;


/**
 * Servlet implementation class enrollCourseServlet
 */
@WebServlet("/enrollCourseServlet")
public class enrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setCharacterEncoding("UTF-8");
	//	PrintWriter out = response.getWriter();
		/*String semester = request.getParameter("semester");
		String select = request.getParameter("select");
	    String name = (String) request.getSession().getAttribute("username");
	    String password	=(String) request.getSession().getAttribute("password"); */
		String select = request.getParameter("select");
		String semester = "SP2005";
		//String select = "CMP101 - 1";
	    String name ="Joe Blow" ;
	    String password	="123"; 
	    User user = new User();
	    user.setUserName(name);
	    user.setPassWord(password);
	    PersonDao personDao =  DaoFactory.createPersonDao();
	    /*String ssn = null;
		Student student =new Student(ssn);*/
	    Student   student  =personDao.getLoginStuent(user);
	    SectionDao sectionDao = DaoFactory.createSectionDao();
	    //Section section =new Section(); 
	    Section   section  =sectionDao.findselectsection(semester, select);
	    EnrollmentStatus status = section.enroll(student);
	    ArrayList<Student> stu = new ArrayList<Student>();
    	ArrayList<Section> secs = new ArrayList<Section>();
    	ArrayList<TranscriptEntry> transcriptEntries = new ArrayList<TranscriptEntry>();
	  //  HashMap<String, Section> sec = new HashMap<String, Section>();   
	    TranscriptDao transcriptDao =  DaoFactory.createTranscriptDao();
	  ///  if(status.value().equals("Enrollment successful!")){
	    	TranscriptEntry transcriptentry=new TranscriptEntry(student, null, section);
	    	   transcriptDao.addTranscript(transcriptentry);
	    	   HashMap<String, TranscriptEntry> enrollcourse = new HashMap<String, TranscriptEntry>();
	    	   enrollcourse= transcriptDao.findEnrollcourseByStudent(user);
	    	   Set<HashMap.Entry<String, TranscriptEntry>> set1=enrollcourse.entrySet();    	
				for (Iterator<Entry<String, TranscriptEntry>> iterator1 = set1.iterator(); iterator1.hasNext();) {  
			    	   HashMap.Entry<String, TranscriptEntry> entry1 = (HashMap.Entry<String, TranscriptEntry>) iterator1.next();  
			            String key1=entry1.getKey();  
			            TranscriptEntry value1=entry1.getValue(); 
			           /* TranscriptEntry transcriptentry1 = new TranscriptEntry(null, null, null);
		            	transcriptentry1.setTranscript(value1);*/
			           Student s= value1.getStudent();
			           stu.add(s);   
			           Section sec= value1.getSection();
			           secs.add(sec);
		            	transcriptEntries.add(value1);
	    	            
	    	
	    }
				request.setAttribute("section", secs);
	            request.getRequestDispatcher("pages/enrollcourse.jsp").forward(request,response);
	//}
	   /* if(status.value().equals("Enrollment failed;  section was full.  :op")){
            String 	alert="Enrollment failed;  section was full.  :op";
            request.setAttribute("alert", alert);
   	 request.getRequestDispatcher("pages/enrollcourse.jsp").forward(request,response);
   }
   if(status.value().equals("Enrollment failed; prerequisites not satisfied.  :op")){
   	 String 	alert="Enrollment failed; prerequisites not satisfied.  :op";
   	 request.setAttribute("alert", alert);
   	 request.getRequestDispatcher("pages/enrollcourse.jsp").forward(request,response);
   }
   	

   if(status.value().equals("Enrollment failed; previously enrolled.  :op")){
   	 String 	alert="Enrollment failed; previously enrolled.  :op";
   	 request.setAttribute("alert", alert);
   	 request.getRequestDispatcher("pages/enrollcourse.jsp").forward(request,response);
   }else{
   	response.sendRedirect("pages/scheduleofclasses.jsp");
   }
	}*/}}
