/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sojit
 */
@Entity
@Table(name="Employee")
public class Employee extends User{
    
   @OneToMany(mappedBy="employee",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   public Set<Task> tasks;
   
   @OneToMany(mappedBy="employee", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
   public Set<Leave> leaves;
   
   @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
   @JoinColumn(name="teamleader_id")
   public TeamLeader teamleader;
    
   public Employee()
   {
       this.tasks = new HashSet<Task>();
   }
   public Employee(User u)
   {
        this.setId(u.getId());
        this.setFname(u.getFname());
        this.setLname(u.getLname());
        this.setEmail(u.getEmail());
        this.setPassword(u.getPassword());
        this.setStatus(0);
        this.setRoleName(URole.EMPLOYEE.getRole());
        this.tasks = new HashSet<Task>();
   }
   

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    
}
