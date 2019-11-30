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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sojit
 */
@Entity
@Table(name="teamleader")
public class TeamLeader extends User {
    
    @OneToMany(mappedBy="teamleader", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    public Set<Employee> employees;
    
    public TeamLeader()
    {
        this.employees = new HashSet<Employee>();
    }
    
    public TeamLeader(User u)
   {
        this.setId(u.getId());
        this.setFname(u.getFname());
        this.setLname(u.getLname());
        this.setEmail(u.getEmail());
        this.setPassword(u.getPassword());
        this.setStatus(0);
        this.setRoleName(URole.TEAMLEADER.getRole());
        this.employees = new HashSet<Employee>();
   }
}
