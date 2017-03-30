package com.paul.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.paul.spring.controller.UserValidator;
import com.paul.spring.dao.UserDAO;
import com.paul.spring.exception.AdException;
import com.paul.spring.pojo.User;

@Controller
@RequestMapping("/adduser.htm")
public class AddUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "addUserForm";
		}	
		

		try {
	
			UserDAO userDao = new UserDAO();
			
			String un =user.getName();
			User u =userDao.get(un);
			if(u!=null){
				return "addUserForm";
			}else{
				userDao.create(user.getName(), user.getPassword(), user.getEmail().getEmailId(), user.getFirstName(), user.getLastName());
			}
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "addedUser";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
}