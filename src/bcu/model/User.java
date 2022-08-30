package bcu.model;

public class User {
	private String id;
	private String name;
	private int phone;
	private String address;
	private int numBooksBorrowed; //Number of Books Borrowed
	
	public int getnumBooksBorrowed(){
		return numBooksBorrowed;
	}
	
	public void setnumBooksBorrowed(int numBooksBorrowed){
		this.numBooksBorrowed = numBooksBorrowed;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
