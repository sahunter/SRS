package daoImpl.mock;

import java.util.HashMap;
import java.util.Map;

import dao.PersonDao;
import model.Professor;
import model.Section;
import model.Student;
import model.User;

public class PersonDaoImpl implements PersonDao {

	@Override
	public HashMap<String, Professor> findAllProfessors() {
		
		HashMap<String, Professor> professors = new HashMap<String, Professor>();
		
		Professor p1, p2, p3;
		p1 = new Professor("Jacquie Barker", "123-45-6789", "Adjunct Professor", "Information Technology");
		professors.put(p1.getSsn(), p1);
		p2 = new Professor("John Smith", "567-81-2345", "Full Professor", "Chemistry");
		professors.put(p2.getSsn(), p2);
		p3 = new Professor("Snidely Whiplash", "987-65-4321", "Full Professor", "Physical Education");
		professors.put(p3.getSsn(), p3);	
		
		//此处应该读取教授所教的课程
		
		
		return professors;
	}

	@Override
	public HashMap<String, Student> findAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getLoginStuent(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
