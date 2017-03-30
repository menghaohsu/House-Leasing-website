package com.paul.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paul.spring.dao.AdvertDAO;
import com.paul.spring.pojo.HouseAdvert;

@Controller
@RequestMapping("/searchHouse.htm")
public class SearchHouseController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String action=request.getParameter("action");
		
		if(action.equals("searchByZipcode"))
		{
			int zipcode=0;
			String a =null;
			a=request.getParameter("zipcode");
			zipcode=Integer.parseInt(a);
			AdvertDAO advertDao=new AdvertDAO();
			List advertList=new ArrayList();
			if(!a.equals(""))
			{
				advertList=advertDao.searchByZipcode(zipcode);
			}
			
	
			mv.addObject("advertList", advertList);
	        mv.setViewName("showResult");
		}
		else if(action.equals("searchByCategory"))
		{
			String category="";
			category=request.getParameter("category");
			AdvertDAO advertDao=new AdvertDAO();
			List advertList=new ArrayList();
			if(!category.equals(""))
			{
				advertList=advertDao.searchByCategory(category);
			}
			
	
			mv.addObject("advertList", advertList);
	        mv.setViewName("showResult");
		}
		
		
		return mv;
	}

}
