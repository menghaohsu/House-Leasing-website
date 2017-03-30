package com.paul.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paul.spring.dao.UserDAO;
import com.paul.spring.pojo.User;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String action = request.getParameter("action");
		if(action.equals("display")){
			mv.setViewName("letlogin");
		}
		if(action.equals("login")){
			//session.invalidate();
			UserDAO userDao = new UserDAO();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username.equals("admin")){
				System.out.println("wtf");
				mv.setViewName("adminHome");
			}else{
				boolean check = userDao.isAdmin(username, password);
				if(!check)
				{
					System.out.println(username);
					System.out.println(password);
					User u=userDao.logIn(username, password);
					
					if(u != null){
			            session.setAttribute("userName", u.getName());
			            mv.setViewName("logInSuccess");
			        }else{
			            mv.addObject("error", "true");
			            mv.setViewName("letlogin");
			        }	
				}
				else 
				{
					 mv.setViewName("adminloginerror");
				}
			}
			
		}else if(action.equals("logout")){
			session.invalidate();
			mv.setViewName("logOutSuccess");

		}
			
		return mv;
	}

}
