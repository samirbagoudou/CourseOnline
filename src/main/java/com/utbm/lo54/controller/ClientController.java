package com.utbm.lo54.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utbm.lo54.entity.Client;
import com.utbm.lo54.service.ClientService;

/** 
* @author Dachen Li
* @date Nov 10, 2017 10:28:02 AM 
* 
*/

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientServices; 
	@PutMapping(value = "/inscription/{sessionId}")
	public String inscriptCourse(@PathVariable("sessionId") String sessionId,
			                                              Client client){
		clientServices.inscriptSession(sessionId,client);
		return "";
	}

}
