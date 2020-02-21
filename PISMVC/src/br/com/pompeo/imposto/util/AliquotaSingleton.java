package br.com.pompeo.imposto.util;

import java.util.Properties;

public class AliquotaSingleton {
	
	//Atributo privado static pertence à classe e nao ao objeto
	//compartilhado por todos os objetos que o acessarem
		
	private static Properties properties;
	
	private static final String ARQ = "/resources/conf.properties";
	//O construtor da classe é privado
	//outros objetos nao podem instanciar AliquotaSingleton
	private AliquotaSingleton() {}
	
	//A única maneira de obter um objeto Properties
	//é através do método públic e estático getInstance()
	//que sempre retornará uma única instancia dessa classe
	
	public static Properties getInstance() {
		//Se properties é nulo, instancia um para retornar
		//desta forma instanciamos apenas um propertie
		if(properties==null) {
			properties = new Properties();
			try {
				properties.load(AliquotaSingleton.class.getResourceAsStream(ARQ));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
		
	}
	
	
	
}
