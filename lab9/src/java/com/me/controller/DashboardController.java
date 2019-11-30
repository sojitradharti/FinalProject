/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.UserDAO;
import com.me.pojo.TeamLeader;
import com.me.pojo.User;
import com.me.validator.UserValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sojit
 */
@Controller

public class DashboardController {
        @Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
        
        @InitBinder("user")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
        @RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "dashboard";
	}
        @RequestMapping(value = "/dashboard/login", method = RequestMethod.GET)
	protected String goToLogin(HttpServletRequest request) throws Exception {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") != null)
            {
                return "dashboard";
            }
		return "login-user";
	}
         @RequestMapping(value = "/dashboard/logout", method = RequestMethod.GET)
	protected String goToLoigout(HttpServletRequest request) throws Exception {
	 HttpSession session = request.getSession();
         session.removeAttribute("user");
            return "dashboard";
	}
        
         @RequestMapping(value = "/dashboard/login", method = RequestMethod.POST)
	protected String LoginUser(HttpServletRequest request) throws Exception {
		HttpSession session =  request.getSession();
                try
                {
                    User user = userDao.get(request.getParameter("email_id"),request.getParameter("password"));
               if(user == null)
               {
                  session.setAttribute("errorMessage", "UserName or Password is incorrect.");
                          return "error";
                           
               }
               else
               {
                    session.setAttribute("user", user);
                    if(user.getRoleName().equals("ADMIN"))
                    {
                        return "admin";
                    }
                    else if(user.getRoleName().equals("TEAMLEADER"))
                    {
                        return "teamleader";
                    }
                    else 
                    {
                         return "employee";
                    }
                    }
                }
                catch(Exception ex)
                {
                    
                }
                return "register-user";
	}
        
       @RequestMapping(value = "/dashboard/register", method = RequestMethod.GET)
	protected ModelAndView registerUser(HttpServletRequest request) throws Exception {
		//System.out.print("registerUser");
                List<TeamLeader> teamlist = userDao.getTeamleaderList();
                request.setAttribute("teamlist", teamlist);
		return new ModelAndView("register-user", "user", new User());

	}
        @RequestMapping(value = "/dashboard/register", method = RequestMethod.POST)
	protected String createUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
                User u = new User();
                String teamid = request.getParameter("teamleader");
                u.setFname(request.getParameter("fname"));
                u.setLname(request.getParameter("lname"));
                u.setEmail(request.getParameter("email"));
                u.setPassword(request.getParameter("password"));
                u.setRoleName(request.getParameter("roleName"));
                u.setStatus(1);
               
                User user1 = userDao.register(u, teamid);
                

		return "dashboard";

	}
        
}
