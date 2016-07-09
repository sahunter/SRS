package dao;

public class DaoFactory {
	private static String daoName = "daoImplsqlite";
//	private static String daoName = "daoImpl.mock";
	
	public static ScheduleDao createScheduleDao() {
		ScheduleDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "ScheduleDao" + "Impl").newInstance();
			result = (ScheduleDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static CourseDao createCourseDao() {
		CourseDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "CourseDaoImpl").newInstance();
			result = (CourseDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static SectionDao createSectionDao() {
		SectionDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "SectionDaoImpl").newInstance();
			result = (SectionDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
	public static UserDao createUserDao() {
		UserDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "UserDaoImpl").newInstance();
			result = (UserDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static PersonDao createPersonDao() {
		PersonDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "PersonDaoImpl").newInstance();
			result = (PersonDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static TranscriptDao createTranscriptDao() {
		TranscriptDao result = null;
		try {
			Object o = Class.forName(daoName + "." + "TranscriptDaoImpl").newInstance();
			result = (TranscriptDao)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
