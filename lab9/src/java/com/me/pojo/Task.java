/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sojit
 */
@Entity
@Table(name="Task")
public class Task {
    
//    constructor
    
     public Task() {
		this.status =Status.PENDING.getRole();
	}
 // properties   
        @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int task_id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column
	private String status;
	
	@Column
	private String taskName;
        
        @Column
	private String description;
        
        @Column
       // @Temporal(TemporalType.TIMESTAMP)
        private  Date startdate;
        
        @Column
        //@Temporal(TemporalType.TIMESTAMP)
        private  Date enddate;
        
        @Column
        @Temporal(TemporalType.TIMESTAMP)
        private  Date actual_startdate;
        
        @Column
        @Temporal(TemporalType.TIMESTAMP)
        private  Date actual_enddate;

         public enum Status{        
		PENDING("PENDING") ,COMPLETED("COMPLETED"), ONGOING("ONGOING");
		private String role;
		public String getRole() {
			return role;
		}
		Status(String role){
			 this.role=role;
		 }
	}
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getActual_startdate() {
        return actual_startdate;
    }

    public void setActual_startdate(Date actual_startdate) {
        this.actual_startdate = actual_startdate;
    }

    public Date getActual_enddate() {
        return actual_enddate;
    }

    public void setActual_enddate(Date actual_enddate) {
        this.actual_enddate = actual_enddate;
    }
        
   
    
   
	
    //getter and setter
    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getStatus() {
		return status;
	}
    public void setStatus(String status) {
		this.status = status;
	}


}
