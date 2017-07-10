package entity;

public class Mail {
	private int mail_id;
	private String sender;
	private String receiver;
	private String daytime;
	private String subject;
	private String message;


	public Mail(String sender,String receiver,String subject,String message){
		this.setId(mail_id);
		this.setTransmitter(sender);
		this.setReceiver(receiver);
		this.setMessage(message);
	}

	public void setId(int id) {
		this.mail_id = id;
	}

	public int getId() {
		return mail_id;
	}

	public String getTransmitter() {
		return sender;
	}

	public void setTransmitter(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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