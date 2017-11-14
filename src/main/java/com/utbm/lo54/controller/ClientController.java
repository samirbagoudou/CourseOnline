package com.utbm.lo54.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utbm.lo54.entity.Client;
import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.service.ClientService;

import ch.qos.logback.core.net.SyslogOutputStream;

/** 
* @author Dachen Li
* @date Nov 10, 2017 10:28:02 AM 
* 
*/

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientServices; 
	
	@GetMapping(value = "/inscription/{sessionId}")
	public ModelAndView goInscript(@PathVariable("sessionId") String sessionId){
		Map<String, String> map = new HashMap<>();
		map.put("sessionId", sessionId);
		return new ModelAndView("inscript", map);
	}
	
	@PostMapping(value = "/inscription")
	@ResponseBody
	public Client inscriptCourse(@RequestParam("sessionId") String sessionId,
			                                              Client client){
		clientServices.inscriptSession(sessionId,client);
		return client;
	}

}
