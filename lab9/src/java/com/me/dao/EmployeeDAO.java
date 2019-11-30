/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.exception.EmployeeException;
import com.me.pojo.Employee;
import com.me.pojo.Task;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author sojit
 */
public class EmployeeDAO extends DAO {
    public EmployeeDAO()
    {
        
    }
    public List<Employee> get() throws EmployeeException {
		try {
			begin();
			Query q = getSession().createQuery("from Employee");
						
			List<Employee> emplist=  q.list();
			commit();
			return emplist;
		} catch (HibernateException e) {
			rollback();
			throw new EmployeeException("Could not get employeelist " + "", e);
		}
	}

    public Employee getSingle(String empid) throws EmployeeException{
        try {
			begin();
			Query q = getSession().createQuery("from Employee where id=:empid");
		        q.setParameter("empid", Integer.parseInt(empid));
			Employee emplist=  (Employee)q.uniqueResult();
			commit();
			return emplist;
		} catch (HibernateException e) {
			rollback();
			throw new EmployeeException("Could not get employeelist " + "", e);
		}
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void saveTask(String task_id) throws EmployeeException{
         try {
			begin();
			Query q = getSession().createQuery("from Task where task_id=:task_id");
		        q.setParameter("task_id", Integer.parseInt(task_id));
			Task task=  (Task)q.uniqueResult();
                        if(task.getStatus().equals("PENDING"))
                        {
                            	Date date = new Date();
                        task.setActual_startdate(date);
                        task.setStatus("ONGOING");
                        }
                        else
                        {
                            //task.setActual_enddate(java.time.LocalDate.now());
                            task.setStatus("COMPLETED");
                        }
                        getSession().save(task);
			commit();
			
		} catch (HibernateException e) {
			rollback();
			throw new EmployeeException("Could not save task " + "", e);
		}
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
