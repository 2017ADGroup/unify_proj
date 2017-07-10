package entity;

public class Rooms {
	private int id;
	private String image_path;
	private String room;
	private String size;
	private String facility;
	private String remarks;

	public Rooms(int id,String image_path,String room, String size, String facility, String remarks){
		this.setId(id);
		this.setImage_path(image_path);
		this.setRoom(room);
		this.setSize(size);
		this.setFacility(facility);
		this.setRemarks(remarks);
	}

	public Rooms(){
	}

	public int getId() {
		return id;
	}


	public void setId(int id){
		this.id = id;
	}





	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getRoom() {
		return room;
	}


	public void setRoom(String room) {
		this.room = room;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
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
}

