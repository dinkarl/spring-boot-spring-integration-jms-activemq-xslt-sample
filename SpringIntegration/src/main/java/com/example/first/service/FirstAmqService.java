package com.example.first.service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

import javax.xml.parsers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.example.first.entity.MessageStore;
import com.example.first.repo.MessageStoreRepo;



@Service("firstAmqService")
public class FirstAmqService {

	Logger log = LoggerFactory.getLogger(FirstAmqService.class);
	
	@Autowired
	MessageStoreRepo messagestore;
	
	public void processMsg(Message<String> msg)  {
		
		String rand=(String) msg.getHeaders().get("ran");
		String randomId = null;
		if(null!=rand) {
			randomId=rand;
		}
		Date date = new Date();
		log.info("**********************************"+randomId);
		MessageStore ms= new MessageStore(randomId,msg.getPayload(),date );
		
		
		messagestore.save(ms);
		
		
		//return msg;
	}
	
	public Message<String> storeID(Message<String> msg) {
		UUID id=UUID.randomUUID();
		String randomId=id.toString();
		msg=MessageBuilder.fromMessage(msg).setHeader("ran", randomId).build();
		return msg;
	}

}
