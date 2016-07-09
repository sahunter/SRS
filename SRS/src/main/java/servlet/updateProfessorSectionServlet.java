package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;

import dao.SectionDao;
import dao.dataAccess;


/**
 * Servlet implementation class addprofessorsection
 */
@WebServlet("/updateProfessorSectionServlet")
public class updateProfessorSectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfessorSectionServlet() {
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
		response.setCharacterEncoding("UTF-8");
		String[] select = request.getParameterValues("select");
		String[] professor = request.getParameterValues("professor");
		for(int j=0;j<select.length;j++){
			String select1 = select[j];
			String professor1=professor[j];
			SectionDao i = DaoFactory.createSectionDao();
			i.updateProfessorSectionServlet(select1, professor1);
		
		}
/*String professor = request.getParameter("professor");
	String	select="CMP101 - 1";
	String	professor="yu";
		 SectionDao sectionDao = DaoFactory.createSectioneDao();
	     sectionDao.updateProfessorSectionServlet(select,professor);*/
	     response.sendRedirect("pages/showallsection.jsp");
		
	}

}
