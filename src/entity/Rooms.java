package entity;

public class Rooms {
	private int room_id;
	private String image_path;
	private String room;
	private String size;
	private String facility;
	private String remarks;

	public Rooms() {
	}

	public Rooms(int room_id, String image_path, String room, String size, String facility, String remarks) {
		super();
		this.room_id = room_id;
		this.image_path = image_path;
		this.room = room;
		this.size = size;
		this.facility = facility;
		this.remarks = remarks;
	}

	public String getFacility() {
		return facility;
	}

	public String getImage_path() {
		return image_path;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getRoom() {
		return room;
	}

	public int getRoom_id() {
		return room_id;
	}

	public String getSize() {
		return size;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
