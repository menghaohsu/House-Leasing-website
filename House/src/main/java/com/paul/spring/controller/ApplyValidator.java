package com.paul.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.paul.spring.pojo.Apply;

@Component
public class ApplyValidator implements Validator {
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(Apply.class);
    }
	
	    public void validate(Object obj, Errors errors)
	    {
	    	Apply newApply = (Apply) obj;

	    }

		

}
