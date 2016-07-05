package daoImpl.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SectionDao;
import model.Course;
import model.Section;

public class SectionDaoImpl implements SectionDao{

	

	@Override
	public HashMap<String, Section> findBySemester(String semester) {
		// 根据semester获取相应的section数据,此处直接手动给出section数据
		HashMap<String, Section> sections = new HashMap<String, Section>();
		Map<String, Course> allCourses = new CourseDaoImpl().findAll();
        
		Section sec1, sec2, sec3, sec4, sec5, sec6, sec7;
		Course c;
		c = allCourses.get("CMP101");
		sec1 = new Section(1,'M', "8:10 - 10:00 PM", c , "GOVT101", 30);
		sections.put(c.getCourseNo() + "-" + sec1.getSectionNo(), sec1);
		sec2 = new Section(2,'W', "6:10 - 8:00 PM", c , "GOVT202", 30);
		sections.put(c.getCourseNo() + "-" + sec2.getSectionNo(), sec2);
		
		c = allCourses.get("OBJ101");
		sec3 = new Section(1,'R', "4:10 - 6:00 PM", allCourses.get("OBJ101"), "GOVT105", 25);
		sections.put(c.getCourseNo() + "-" + sec3.getSectionNo(), sec3);
		sec4 = new Section(2,'T', "6:10 - 8:00 PM", allCourses.get("OBJ101"), "SCI330", 25);
		sections.put(c.getCourseNo() + "-" + sec4.getSectionNo(), sec4);
		
		
		c = allCourses.get("CMP283");
		sec5 = new Section(1,'M', "6:10 - 8:00 PM", allCourses.get("CMP283"), "GOVT101", 20);
		sections.put(c.getCourseNo() + "-" + sec5.getSectionNo(), sec5);
		
		c = allCourses.get("CMP999");
		sec6 = new Section(1, 'R', "4:10 - 6:00 PM", allCourses.get("CMP999"), "SCI241", 15);
		sections.put(c.getCourseNo() + "-" + sec6.getSectionNo(), sec6);
		
		c = allCourses.get("ART101");
		sec7 = new Section(1, 'M', "4:10 - 6:00 PM", allCourses.get("ART101"), "ARTS25", 40);
		sections.put(c.getCourseNo() + "-" + sec7.getSectionNo(), sec7);
		
		return sections;
	}

	@Override
	public HashMap<String, Section> findAllsection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Section findselectsection(String semester, String select) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Section> findsection() {
		// TODO Auto-generated method stub
		return null;
	}

}
