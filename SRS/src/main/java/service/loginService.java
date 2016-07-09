package service;


import dao.DaoFactory;
import dao.UserDao;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import model.User;

public class loginService {
	
//	private UserDao userDao = null;
	public static  boolean checklogin(String username,String password){
	
		//courses = new CourseCatalog(userDao.findAll());
		 User user = new User();
		    user.setUserName(username);
		    user.setPassWord(password);
		  
				if(user.getUserName()!=null && user.getPassWord()!=null){
					UserDao userDao = DaoFactory.createUserDao();
					User Acctount=new User();
					 Acctount=userDao.getUser(user);
					if( Acctount!=null && Acctount.getPassWord().equals(user.getPassWord())){
						return true;
						
					}
					return false;
				}
				return false;
}}
