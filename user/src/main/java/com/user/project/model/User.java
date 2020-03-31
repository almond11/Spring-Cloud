package com.user.project.model;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    public User() {

    }

    public User(long id, String firstName, String lastName, String address,String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address=address;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

	public void setAddress(String d) {
		this.address=d;		
	}

	public String getAddress() {
		return address;
	}
}