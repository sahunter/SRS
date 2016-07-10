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
 * Servlet implementation class searchTranscriptServlet
 */
@WebServlet("/searchTranscriptServlet")
public class searchTranscriptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchTranscriptServlet() {
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
		
	
		//String username = request.getParameter("username");
	 String username=(String) request.getSession().getAttribute("username");
	 String password=(String)request.getSession().getAttribute("password");
	    
	    User  user=new User();
		user.setUserName(username);
		user.setPassWord(password);
	    TranscriptDao transcriptDao = DaoFactory.createTranscriptDao();
	    HashMap<String, TranscriptEntry> transcript=new HashMap<String, TranscriptEntry>();
	    transcript   =transcriptDao.searchTranscript(user);
	    ArrayList<TranscriptEntry> tran = new ArrayList<TranscriptEntry>();
		 ArrayList<String> keys = new ArrayList<String>();
		  Set<Entry<String, TranscriptEntry>> set=transcript.entrySet();    
         for (Iterator<Entry<String, TranscriptEntry>> iterator = set.iterator(); iterator.hasNext();) {  
        	 Entry<String, TranscriptEntry> entry =iterator.next();  
               String key=entry.getKey();  
               TranscriptEntry value=entry.getValue(); 
           
               tran.add(value);
                 keys.add(key);    
         }
		    request.setAttribute("transcript", tran);
		    request.setAttribute("keys", keys);
		    request.getRequestDispatcher("pages/showpersonnaltranscript.jsp").forward(request,response);
	}

}
