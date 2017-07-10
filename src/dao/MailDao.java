package dao;

import com.sun.corba.se.pept.transport.Connection;

import entity.Mail;

public class MailDao {

	private static final String SQL_SELECT_ID_AND_PASS = "SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?";

	private Connection connection;

	public MailDao(Connection connection) {
		this.connection = connection;
	}

	public Mail mailSelect(){
		return null;
	}

<<<<<<< HEAD
	public Mail mailInsert(){
		return null;
=======
	public void test(){

>>>>>>> c0baa8aa073704ceaca6ad1c17412c5ff2210ca9
	}

}
