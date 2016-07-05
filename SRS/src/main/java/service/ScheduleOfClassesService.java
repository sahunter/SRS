package service;

import java.util.Map;

import dao.DaoFactory;
import dao.SectionDao;
import model.ScheduleOfClasses;
import model.Section;

public class ScheduleOfClassesService {
	
    private static ScheduleOfClasses sc;

    private static SectionDao dao;
    public ScheduleOfClasses getScheduleOfClasses() {
		return sc;
	}    
   
    
    public ScheduleOfClassesService(String semester, SectionDao dao){
    	sc = new ScheduleOfClasses(semester, dao.findBySemester(semester));
    }
  



}
