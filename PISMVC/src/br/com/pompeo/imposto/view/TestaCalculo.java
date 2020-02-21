package br.com.pompeo.imposto.view;

import br.com.pompeo.imposto.control.ImpostoController;
import br.com.pompeo.imposto.model.Pis;

public class TestaCalculo {
	
	public static void main(String[] args) {
		
		Pis modelPis = new Pis();
		CalculaPis viewCalculaPis = new CalculaPis();
		//Adiciona um observador para o objeto observado
		modelPis.addObserver(viewCalculaPis);
		//Instancia um Controller e informa quem ele controlará
		ImpostoController controller = new ImpostoController(modelPis, viewCalculaPis);
		//Envia o controller criado para a view
		viewCalculaPis.addController(controller);
	}

}
