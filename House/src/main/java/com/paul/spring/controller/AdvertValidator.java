package com.paul.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.paul.spring.pojo.HouseAdvert;

@Component
public class AdvertValidator implements Validator {
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(HouseAdvert.class);
    }
	
	    public void validate(Object obj, Errors errors)
	    {
	    	HouseAdvert newHouse = (HouseAdvert) obj;

	    }

		

}

