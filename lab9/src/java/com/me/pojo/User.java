/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author saravandeepak
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
  
   
    
    //We use set because we dont want duplicates.
    
    public User() {
        
    }

    public User(String fname, String lname, String email, String password, String roleName) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
		this.status = 0;
	}
    public enum URole{
		ADMIN("ADMIN") ,TEAMLEADER("TEAMLEADER"), EMPLOYEE("EMPLOYEE");
		private String role;

		public String getRole() {
			return role;
		}
		 URole(String role){
			 this.role=role;
		 }
	}
	@Id
	@GeneratedValue
	private int id;
		
	@Column(name="firstName")
	private String fname;
	
	@Column(name="lastName")
	private String lname;
	
	@Column(name="email_id")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="roleName")
	private String roleName;
	
	@Column(name="status")
	private int status;
	

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
