package dao;

import java.util.HashMap;
import java.util.List;

import model.Section;

public interface SectionDao {

	
	public HashMap<String,Section> findBySemester(String semester);
	public HashMap<String, Section> findAllsection();
	public Section findselectsection(String semester,String select);
	 public HashMap<String, Section> findsection();
}
