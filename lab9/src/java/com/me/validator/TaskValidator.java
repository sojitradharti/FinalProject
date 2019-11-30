/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.validator;

import com.me.pojo.Task;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author sojit
 */
public class TaskValidator implements Validator {
    
    @Override
    public boolean supports(Class aclass)
    {
        return aclass.equals(Task.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Task emp =(Task)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskName", "error.invalid.task", "task name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.task", "description Required");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
