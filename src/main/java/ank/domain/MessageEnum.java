package ank.domain;

public enum MessageEnum {
	
	ASK_LOCATION,
	ASK_ENTER,
	ASK_PASS,
	SHOW_PASSDESC,
	SHOW_LOCDESC,
	SHOW_HELPDESC;
	
	public static MessageEnum get(String value){
		MessageEnum foundArgEnum = null;
		for (MessageEnum messageEnum : MessageEnum.values()) {
			if(messageEnum.name().equalsIgnoreCase(value)){
				foundArgEnum = messageEnum;
				break;
			}
		}
		return foundArgEnum;
	}

}
