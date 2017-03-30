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
import com.paul.spring.dao.ApplyDAO;
import com.paul.spring.pojo.Apply;

@Controller
@RequestMapping("/showapply.htm")
public class ShowApplyController {
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		String action = request.getParameter("action");
		
		
		if(action.equals("display"))
		{
			ApplyDAO applyDao= new ApplyDAO();
			List applyList=new ArrayList();
			applyList=applyDao.showAll();
			mv.addObject("applyList", applyList);
			mv.setViewName("showApply");
		}
		if(action.equals("approve"))
		{
			String[] title = request.getParameterValues("title");
		    String[] username=request.getParameterValues("applyBy");
		    System.out.println("title"+title[0]);
		    System.out.println(username[0]);
			
			for(int i=0;i<title.length;i++)
			{
				ApplyDAO applyDao=new ApplyDAO();
				Apply a=applyDao.search(title[i],username[i]);
				System.out.println(a.getApplyBy());
				System.out.println(title[i]);
				applyDao.approve(a);
				mv.setViewName("showApply");
			}
			
		}
		if(action.equals("disapprove"))
		{
			String[] title = request.getParameterValues("title");
			String[] username=request.getParameterValues("applyBy");
			
			for(int i=0;i<title.length;i++)
			{
				ApplyDAO applyDao=new ApplyDAO();
				Apply a=applyDao.search(title[i],username[i]);
				applyDao.disaprove(a);
				mv.setViewName("showApply");
			}
			
		}
		
		
		return mv;
		
	}

}
