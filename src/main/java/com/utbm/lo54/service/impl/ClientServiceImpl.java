package com.utbm.lo54.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utbm.lo54.entity.Client;
import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.repository.ClientRepository;
import com.utbm.lo54.service.ClientService;

/** 
* @author Dachen Li
* @date Nov 10, 2017 10:28:58 AM 
* 
*/
@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public String inscriptSession(String sessionId, Client client) {
		CourseSession courseSession = new CourseSession();
		courseSession.setId(Integer.parseInt(sessionId));
		client.setSession(courseSession);
		return clientRepository.saveInscription(client);
	}
	
}
