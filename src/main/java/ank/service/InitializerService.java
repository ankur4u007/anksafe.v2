package ank.service;

import java.io.File;

public class InitializerService {
	private static final String SAFE_HOME = ".anksafe";
	private final File homeDir;

	private InitializerService(final String dir) {
		homeDir = new File(dir);
		if(!homeDir.exists()){
			homeDir.mkdir();	
		}
	}

	public static InitializerService init(final String pathArg) {
		final File file = new File(pathArg);
		final String dir = file.isDirectory() ? pathArg : file.getParent();
		return new InitializerService(dir + "/" + SAFE_HOME);
	}
	
	public String getHomeDir(){
		return homeDir.getAbsolutePath();
	}

}
