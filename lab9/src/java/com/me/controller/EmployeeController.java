/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.EmployeeDAO;
import com.me.pojo.Employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sojit
 */
@Controller
@RequestMapping("/employee/")
public class EmployeeController {
    
     @Autowired
    @Qualifier("empDao")
    EmployeeDAO empDao;
     
    @RequestMapping(value="/", method =RequestMethod.GET)
    public String gotoEmpView(HttpServletRequest request) throws Exception
    {
        return "employee";
    }
    
    @RequestMapping(value="/managetask", method=RequestMethod.GET)
    public String GoToManageTask(HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession();
        Employee emp = (Employee) session.getAttribute("user");
        request.setAttribute("taskList",emp.getTasks() );
        return  "managetask";
    }
    @RequestMapping(value="/fetchTask", method=RequestMethod.GET)
    public String GoToTask(HttpServletRequest request) throws Exception
    {
       String task_id= request.getParameter("paramTask");
        
        empDao.saveTask(task_id);
        HttpSession session = request.getSession();
        
        Employee emp = (Employee) session.getAttribute("user");
        emp = empDao.getSingle(emp.getId()+"");
        session.setAttribute("user",emp);
        request.setAttribute("taskList",emp.getTasks() );
        return  "managetask";
    }
  
    @RequestMapping(value="/leaverequest", method=RequestMethod.GET)
    public String GoToLeaveRequest(HttpServletRequest request) throws Exception
    {       
        return  "leaverequest";
    }
}
