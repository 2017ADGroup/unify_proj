package entity;

public class Mail {
	private int mail_id;
	private String receiver;
	private String sender;
	private String daytime;
	private String subject;
	private String message;

	public Mail(int mail_id, String receiver, String sender, String daytime, String subject, String message) {
		this.mail_id = mail_id;
		this.sender = sender;
		this.receiver = receiver;
		this.daytime = daytime;
		this.subject = subject;
		this.message = message;
	}

	public Mail(String receiver, String sender, String daytime, String subject, String message) {
		this.receiver = receiver;
		this.sender = sender;
		this.daytime = daytime;
		this.subject = subject;
		this.message = message;
	}

	public int getMail_id() {
		return mail_id;
	}

	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}