package ank;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ank.service.InitializerService;

public class Main {

	public static void main(String[] args) {
		
		List<String> argList = Arrays.asList(args);
		List<String> success = new ArrayList<>();
		List<String> failures = new ArrayList<>();
		argList.parallelStream().forEach( item -> {
			File file = new File(item);
			if(file.exists()){
				String homeDir = InitializerService.init(file.getAbsolutePath()).getHomeDir();
				System.out.println(homeDir);
				success.add(item);
			} else {
				failures.add(item);
			}
		} );
	}

}
