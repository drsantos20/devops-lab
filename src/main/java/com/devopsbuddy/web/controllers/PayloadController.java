/**
 * 
 */
package com.devopsbuddy.web.controllers;
/**
 * @author Daniel on 21 de abr de 2017
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayloadController {
	
	public static final String PAYLOAD_VIEW_NAME = "payload/payload";
	
	@RequestMapping("/payload")
	public String payLoad() {
		return PAYLOAD_VIEW_NAME;
	}

}
