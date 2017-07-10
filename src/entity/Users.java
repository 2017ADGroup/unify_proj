package entity;

public class Users {
	private int user_id;
	private String login_id;
	private String password;
	private String property;
	private String name;
	private String kana;
	private int authority;
	private String organization;

	public Users(){

	}

	public Users(int user_id,String login_id,String password,String property,String name,String kana,int authority,String organization){
		this.user_id = user_id;
		this.login_id = login_id;
		this.password = password;
		this.property = property;
		this.name = name;
		this.kana = kana;
		this.authority = authority;
		this.organization = organization;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}


