package models;

public class account {
	private long id;
	private String loginID;
	private String password;
	private int permission;
	private String name;
	private String address;
	private String birthday;
	private int gender;

	public account() {
		super();
	}
	
	public account(long id, String loginID, String password, int permission, String name, String address,
			String birthday, int gender) {
		super();
		this.id = id;
		this.loginID = loginID;
		this.password = password;
		this.permission = permission;
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.gender = gender;
	}

	public account(String loginID, String password, int permission, String name, String address) {
		super();
		this.loginID = loginID;
		this.password = password;
		this.permission = permission;
		this.name = name;
		this.address = address;
	}
	public account(long id,String loginID, String password, int permission) {
		super();
		this.loginID = loginID;
		this.password = password;
		this.permission = permission;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	
}
