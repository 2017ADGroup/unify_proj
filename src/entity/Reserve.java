package entity;

public class Reserve {
	private int reserve_id;
	private String reserve_date;
	private int term;
	private String room;
	private int purpose;
	private int amount;
	private String facility;
	private String remarks;
	private String reserve_host;



	public Reserve(){

	}



	public Reserve(int reserve_id, int purpose, int amount, String facility, String remarks) {
		super();
		this.reserve_id = reserve_id;
		this.purpose = purpose;
		this.amount = amount;
		this.facility = facility;
		this.remarks = remarks;
	}



	public Reserve(int reserve_id,String reserve_date, int term,
			String room,int purpose,int amount,String facility,String remarks,String reserve_host){
		this.reserve_id = reserve_id;
		this.reserve_date = reserve_date;
		this.term = term;
		this.room = room;
		this.purpose = purpose;
		this.amount = amount;
		this.facility = facility;
		this.remarks = remarks;
		this.reserve_host = reserve_host;
	}


	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getPurpose() {
		return purpose;
	}
	public void setPurpose(int purpose) {
		this.purpose = purpose;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getReserve_host() {
		return reserve_host;
	}
	public void setReserve_host(String reserve_host) {
		this.reserve_host = reserve_host;
	}



	public String getReserve_date() {
		return reserve_date;
	}



	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}
}
