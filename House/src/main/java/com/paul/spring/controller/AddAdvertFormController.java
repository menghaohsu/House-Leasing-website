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

import com.paul.spring.dao.AdvertDAO;
import com.paul.spring.dao.CategoryDAO;
import com.paul.spring.dao.UserDAO;
import com.paul.spring.exception.AdException;
import com.paul.spring.pojo.HouseAdvert;
import com.paul.spring.pojo.HouseCategory;
import com.paul.spring.pojo.User;

@Controller
@RequestMapping("/addadvert.htm")
public class AddAdvertFormController {
	
	@Autowired
	@Qualifier("advertValidator")
	AdvertValidator advertValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(advertValidator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("houseAdvert")HouseAdvert houseAdvert,BindingResult result) throws Exception{

		advertValidator.validate(houseAdvert, result);
		if(result.hasErrors())
		{
			return "addAdvertForm";
		}
    	
    	
    
        String categoryTitle = houseAdvert.getCategory_name();   //get category user from addAdvertForm
        String title = houseAdvert.getTitle();      //get advert title user from addAdvertForm
        int bedrooms = houseAdvert.getBedrooms();
        int bathrooms = houseAdvert.getBathrooms();
        int livingrooms=houseAdvert.getLivingrooms();
        String address=houseAdvert.getAddress();
        int accomodate = houseAdvert.getAccommodate();
        int zipcode = houseAdvert.getZipcode();
        

        try {
            //UserDAO users = new UserDAO();
            CategoryDAO categories = new CategoryDAO();
            AdvertDAO advertDAO = new AdvertDAO();
            

            //searching from database
            HouseCategory category = categories.get(categoryTitle);
            
            //insert a new advert
            HouseAdvert ha = advertDAO.create(title, address, bedrooms, bathrooms, livingrooms, accomodate, category.getId(), category.getTitle(),zipcode);

            category.addAdvert(ha);
            categories.save(category);
            
            

            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "addedAdvert";
    }
    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("houseAdvert")HouseAdvert houseAdvert, BindingResult result) { 
   
        return "addAdvertForm"; 
    }

}
