/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.EmployeeDAO;
import com.me.dao.TaskDAO;
import com.me.pojo.Employee;
import com.me.pojo.Task;
import com.me.validator.TaskValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sojit
 */
@Controller
@RequestMapping("/teamleader/*")
public class TeamLeaderController {
    
    @Autowired
    @Qualifier("empDao")
    EmployeeDAO empDao;
    
      @Autowired
    @Qualifier("taskDao")
      TaskDAO taskDao;
    
    @Autowired
    @Qualifier("taskValidator")
    TaskValidator taskValidator;
    
    @InitBinder
    public void inint(WebDataBinder binder)
    {
        binder.setValidator(taskValidator);
    }
    @RequestMapping(value="/assigntask", method=RequestMethod.GET )
    protected ModelAndView assignTask(HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession();
            if(session.getAttribute("user") == null)
            {
                return new ModelAndView("dashboard"); 
            }
        List<Employee> empList = empDao.get();
        request.setAttribute("empList", empList);
        return new ModelAndView("assigntask","task",new Task()); 
    }
    
    @RequestMapping(value="/teamleader/assigntask" ,method=RequestMethod.POST )
    protected ModelAndView saveTask (@ModelAttribute("task") Task task, BindingResult result, HttpServletRequest request)throws Exception
    {
        
        
       // taskValidator.validate(task, result);
//        if (result.hasErrors()) {
//              List<Employee> empList = empDao.get();
//        request.setAttribute("empList", empList);
//            return new ModelAndView("assigntask","task",task); 
//       }
      Employee emp = empDao.getSingle(request.getParameter("empId"));
      taskDao.saveTask(task, emp);
     
      return new ModelAndView("teamleader");
    }
}
