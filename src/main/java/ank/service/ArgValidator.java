package ank.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ank.domain.ArgsEnum;

public class ArgValidator {
	
	private final List<String> arguments;
	
	private ArgValidator(List<String> args){
		this.arguments = args;
	}
	
	public static ArgValidator init(List<String> args){
		return new ArgValidator(args);
	}
	
	public boolean isValid(){
		return hasValidCombination() && isValidArg();
	}
	
	private boolean isValidArg() {
		// TODO Auto-generated method stub
		arguments.stream()
		return false;
	}

	private boolean hasValidCombination(){
		return ArgsEnum.getValidCombinations().parallelStream().anyMatch( argEnums -> {
			return argEnums.stream().allMatch(argEnum -> {

				arguments.parallelStream().filter(argument -> {
					return ArgsEnum.isValidArg(argument) ;
				}).collect(Collectors.);
			});
		});
		
		if (arguments.length > maxAllowedLength ) {
			return false;
		} else {
			
		}
	}

}
