package com.me.dao;

import com.me.exception.UserException;
import com.me.pojo.Employee;
import com.me.pojo.TeamLeader;
import com.me.pojo.User;
import com.me.pojo.User.URole;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String email_id, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where email_id = :email_id and password = :password");
			q.setString("email_id", email_id);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + email_id, e);
		}
	}
	
	public User get(int id) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where id= :id");
			q.setInteger("id", id);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + id, e);
		}
	}

	public User register(User u,String id)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

                        if(u.getRoleName().equals(URole.EMPLOYEE.getRole()))
                        {
                            Employee emp = new Employee(u);
                            Query q = getSession().createQuery("from TeamLeader where id= :id");
			    q.setString("id", id);	
                            
			    TeamLeader TeamLeader = (TeamLeader) q.uniqueResult();
                            emp.teamleader = TeamLeader;
                            getSession().save(emp);
                        }
                        else if (u.getRoleName().equals(URole.TEAMLEADER.getRole()))
                        {
                            TeamLeader tl = new TeamLeader(u);
                             getSession().save(tl);
                        }
			
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getFname(), e);
		}
	}

    public List<TeamLeader> getTeamleaderList() throws UserException{
        try
        {
            begin();
             Query q = getSession().createQuery("from TeamLeader");
             List<TeamLeader> list = q.list();             
             commit();
             return list;
        }
        catch(HibernateException ex)
        {
            rollback();
            throw new UserException("Could not get teamleader list for register page" + ""+ex);
        }
                
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}