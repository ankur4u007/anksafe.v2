package ank.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import ank.domain.MessageEnum;

public class PropertyService {
	
	private static final String MESSAGES_PROPERTIES = "messages.properties";
	private final Map<MessageEnum, String> messageMap;
	
	private PropertyService(Map<MessageEnum, String> messageMap) {
		this.messageMap = messageMap;
	}

	public PropertyService load(){
		Properties prop = new Properties();
		InputStream resourceAsStream = getClass().getResourceAsStream(MESSAGES_PROPERTIES);
		
		try {
			prop.load(resourceAsStream);
		} catch (IOException e) {
			// nothing here
		}
		Map<MessageEnum, String> messageMap = new HashMap<>();
		prop.forEach((key,value) -> {
			MessageEnum messageEnum = MessageEnum.get((String) key);
			if(messageEnum != null) {
				messageMap.put(messageEnum, (String)value);
			}
		});
		return new PropertyService(messageMap);
	}
	
	public Map<MessageEnum, String> getMessageMap(){
		Map<MessageEnum, String> messageMapToReturn = new HashMap<>();
		messageMap.forEach((k,v)  -> {
			messageMap.put(k,v);
		});
		return messageMapToReturn;
	}

}
