package br.com.facerecognition.util;


import java.io.File;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;


public class ConfiguracaoPortal {
	private static ConfiguracaoPortal instance = null;
	private XMLConfiguration config = null;
	
	private ConfiguracaoPortal() throws Exception {
		File f = new File("./bioface.xml");
		
		Configurations configs = new Configurations();
		
		if(f.exists()) 
			this.config = configs.xml(f);
		else{
			this.config = configs.xml("portalConfig.xml");	
		}
	}
	
	public static ConfiguracaoPortal getInstance() throws Exception{ 
		if(ConfiguracaoPortal.instance==null){
			ConfiguracaoPortal.instance = new ConfiguracaoPortal();
		}
		return instance;
	}

	public XMLConfiguration getConfig() {
		return config;
	}
	
}












