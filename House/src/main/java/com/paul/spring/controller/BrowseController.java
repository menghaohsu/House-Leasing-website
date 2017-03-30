package com.paul.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paul.spring.dao.AdvertDAO;

@Controller
@RequestMapping("/browse.htm")
public class BrowseController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String action=request.getParameter("action");
		if(action.equals("display"))
		{
			

			AdvertDAO advertDao=new AdvertDAO();
			List advertList=new ArrayList();

			advertList=advertDao.search();
			
	
			mv.addObject("advertList", advertList);
	        mv.setViewName("browse");
		}
		
		
		return mv;
	}

}
