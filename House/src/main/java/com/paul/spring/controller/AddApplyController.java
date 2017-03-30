package com.paul.spring.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.paul.spring.dao.ApplyDAO;
import com.paul.spring.pojo.Apply;
import com.paul.spring.pojo.HouseAdvert;

@Controller
@RequestMapping("/applyHouse.htm")
public class AddApplyController {
	
	@Autowired
	@Qualifier("applyValidator")
	ApplyValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String action = request.getParameter("action");
		String username=(String) session.getAttribute("userName");
		
//		if(username==null){
//		
//			mv.setViewName("addUserForm");
//		}else 
		if(action.equals("addDB"))
		{
			
			String[] title = request.getParameterValues("title");
			String[] address = request.getParameterValues("address");
			String[] bedrooms1 = request.getParameterValues("bedrooms");
			String[] bathrooms1 = request.getParameterValues("bathrooms");
			String[] livingrooms1 = request.getParameterValues("livingrooms");
			String[] zipcode1 = request.getParameterValues("zipcode");
			String[] accommodate1 = request.getParameterValues("accommodate");
			String status ="Waiting";

			
			int[]bathrooms=new int[bathrooms1.length];
			for(int i=0; i<bathrooms.length; i++){
				bathrooms[i]=Integer.parseInt(bathrooms1[i]);
			}
			int[]bedrooms=new int[bedrooms1.length];
			for(int i=0; i<bedrooms.length; i++){
				bedrooms[i]=Integer.parseInt(bedrooms1[i]);
			}
			int[]accommodate=new int[accommodate1.length];
			for(int i=0; i<accommodate.length; i++){
				accommodate[i]=Integer.parseInt(accommodate1[i]);
			}
			int[]zipcode=new int[zipcode1.length];
			for(int i=0; i<zipcode.length; i++){
				zipcode[i]=Integer.parseInt(zipcode1[i]);
			}
			int[]livingrooms=new int[livingrooms1.length];
			for(int i=0; i<livingrooms.length; i++){
				livingrooms[i]=Integer.parseInt(livingrooms1[i]);
			}
			
			
			for(int i=0;i<title.length;i++)
			{
				System.out.println("taxi");
				ApplyDAO applyDao=new ApplyDAO();
			
				applyDao.create(title[i],address[i], bedrooms[i], bathrooms[i],livingrooms[i],accommodate[i],zipcode[i], username,status);
				mv.setViewName("showApplyResult");
			}
				
		}
			
	
		return mv;
	}
}