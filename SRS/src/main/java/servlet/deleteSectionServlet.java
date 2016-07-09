package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DaoFactory;
import dao.TranscriptDao;
import dao.dataAccess;
import model.User;

/**
 * Servlet implementation class deleteCourseServlet
 */
@WebServlet("/deleteCourseServlet")
public class deleteSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSectionServlet() {
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
		String[] FullSectionNo = request.getParameterValues("checkboxname");
		  String name ="Joe Blow" ;
		    String password	="123"; 
		    User user = new User();
		    user.setUserName(name);
		    user.setPassWord(password);
		for(int j=0;j<FullSectionNo.length;j++){
			String FullSectionNo1 = FullSectionNo[j];
			TranscriptDao i = DaoFactory.createTranscriptDao();
			i.deleteTranscript(name,FullSectionNo1);	
		}
		  response.sendRedirect("enrollcourse.jsp");  
	}
	}


