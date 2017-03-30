package com.paul.spring.controller;

import com.paul.spring.pojo.HouseCategory;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

@Component
public class CategoryValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(HouseCategory.class);
    }

    public void validate(Object obj, Errors errors)
    {
        HouseCategory newCategory = (HouseCategory) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.category", "Category Required");
    }
}
