/**
 * 
 */
package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Daniel on 16 de abr de 2017
 */
@Controller
public class IndexController {
	
	private static final String INDEX_HOME_PAGE = "index";
	
	@RequestMapping("/") 
	public String home() {
		return INDEX_HOME_PAGE;
	}
		
	
	

}
