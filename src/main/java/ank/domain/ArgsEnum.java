package ank.domain;

import static ank.domain.MessageEnum.SHOW_HELPDESC;
import static ank.domain.MessageEnum.SHOW_LOCDESC;
import static ank.domain.MessageEnum.SHOW_PASSDESC;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum ArgsEnum {

	PASSPHRASE("-p", "--passphrase", SHOW_PASSDESC),
	LOCATION("-l", "--location", SHOW_LOCDESC),
	HELP("-h", "--help", SHOW_HELPDESC);
	
	private final String shortArg;
	private final String longArg;
	private final MessageEnum desc;
	
	private ArgsEnum(String shortArg, String longArg, MessageEnum desc) {
		this.shortArg = shortArg;
		this.longArg = longArg;
		this.desc = desc;
	}
	
	public static ArgsEnum find(String arg) {
		ArgsEnum foundArgEnum = null;
		for (ArgsEnum argsEnum : ArgsEnum.values()) {
			if(argsEnum.shortArg.equalsIgnoreCase(arg) || 
					argsEnum.longArg.equalsIgnoreCase(arg)){
				foundArgEnum = argsEnum;
				break;
			}
		}
		return foundArgEnum;
	}
	
	public static String getHelpMenu(final Map<MessageEnum, String> messages){
		StringBuilder stringBuilder = new StringBuilder("Usage: \\n\\r");
		for (ArgsEnum argsEnum : ArgsEnum.values()) {
				stringBuilder.append(argsEnum.shortArg)
				.append(" OR ")
				.append(argsEnum.longArg)
				.append("\\t").append(messages.getOrDefault(argsEnum.desc, ""));
			}
		return stringBuilder.toString();
	}
	
	public static List<List<ArgsEnum>> getValidCombinations(){
		return Arrays.asList(Arrays.asList(PASSPHRASE, LOCATION),
				Arrays.asList(HELP));
	}
	
	public static boolean isValidArg(String arg){
		return find(arg) != null;
	}
	
}
