package com.paul.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paul.spring.dao.ApplyDAO;
import com.paul.spring.dao.UserDAO;
import com.paul.spring.pojo.User;

@Controller
@RequestMapping("/application.htm")
public class CheckApplicationStatusController {
	
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String action = request.getParameter("action");
		String username=(String) session.getAttribute("userName");
		System.out.println("username="+username);
		
		UserDAO userDao = new UserDAO();
		User u =userDao.get(username);
		if(u==null){
			mv.setViewName("letlogin");
		}
		else if(action.equals("action"))
		{
			ApplyDAO applyDao=new ApplyDAO();								
			List applyList=new ArrayList();
			applyList=applyDao.check(username);

			mv.addObject("applyList1", applyList);
			mv.setViewName("application");
		}		
		return mv;
	}

}
