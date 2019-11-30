/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import static com.me.dao.DAO.getSession;
import com.me.exception.UserException;
import com.me.pojo.Employee;
import com.me.pojo.Task;
import org.hibernate.HibernateException;

/**
 *
 * @author sojit
 */
public class TaskDAO extends DAO {
    
    public TaskDAO()
    {
        
    }
    public Task saveTask(Task t,Employee e)
			throws UserException {
		try {
			begin();
		        t.setEmployee(e);
                        getSession().save(t);   
			commit();
			return t;
                

		} catch (HibernateException ex) {
			rollback();
			throw new UserException("Exception while creating user: " + ex.getMessage());
		}
	}
}
