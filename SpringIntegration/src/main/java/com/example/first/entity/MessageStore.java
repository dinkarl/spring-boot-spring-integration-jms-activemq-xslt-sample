package com.example.first.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.messaging.Message;






@Entity
@Table(name="MessageStore")
public class MessageStore {

	@Id
	@Column
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "messageid") 
    
	private String messageId;
	
	
	@Lob
    private String payload; 
	
	@Column(name = "date_time") 
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getPayload() {
		return payload;
	}

	public MessageStore()
	{
		
	}
	
	
	public MessageStore(String messageId, String msg, Date today) {
		super();
		this.messageId = messageId;
		this.payload = msg;
		this.dateTime = today;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
