package dao;

import java.util.HashMap;
import java.util.List;

import model.Section;
import model.User;

public interface SectionDao {

	
	public HashMap<String,Section> findBySemester(String semester);
	public HashMap<String, Section> findAllsection();
	public Section findselectsection(String semester,String select);
	 public HashMap<String, Section> findsection();
	//void addProfessorSectionServlet(String fullSectionNo, String professor);
	void updateProfessorSectionServlet(String fullSectionNo, String professor);

	void deleteSection(String FullSectionNo);
	void addSection(String fullSectionNo, Section section, String representedCourse);
	void updateSection(String fullSectionNo, Section section, String representedCourse);
	HashMap<String, Section> findByName(User user);
	public HashMap<String, Section> findsectionByProfessor(User user);
	
		
	 
}
