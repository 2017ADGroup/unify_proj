package entity;

public class MailView {

	private String receivername;
	private String sendername;

	public MailView(String receivername,String sendername) {
		this.sendername = sendername;
		this.receivername = receivername;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}


}
