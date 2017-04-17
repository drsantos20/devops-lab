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
	@RequestMapping("/") 
	public String home() {
		return "index";
	}
		
	
	

}
