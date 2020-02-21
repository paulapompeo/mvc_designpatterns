package br.com.pompeo.imposto.util;

import java.util.Properties;

public class AliquotaSingleton {
	
	//Atributo privado static pertence � classe e nao ao objeto
	//compartilhado por todos os objetos que o acessarem
		
	private static Properties properties;
	
	private static final String ARQ = "/resources/conf.properties";
	//O construtor da classe � privado
	//outros objetos nao podem instanciar AliquotaSingleton
	private AliquotaSingleton() {}
	
	//A �nica maneira de obter um objeto Properties
	//� atrav�s do m�todo p�blic e est�tico getInstance()
	//que sempre retornar� uma �nica instancia dessa classe
	
	public static Properties getInstance() {
		//Se properties � nulo, instancia um para retornar
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
