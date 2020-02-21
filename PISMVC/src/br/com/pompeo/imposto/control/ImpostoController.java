package br.com.pompeo.imposto.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.pompeo.imposto.model.Imposto;
import br.com.pompeo.imposto.view.TelaDeImposto;

//ImpostoController implementa ActionListener para capturar
//o evento do botao da View

public class ImpostoController implements ActionListener{
	
	//O controller possui referencias a Imposta e a TelaDeImposto
	//É reutilizavel para Telas que calculem Impostos
	//Ou seja, classes que implementem essas interfaces
	private Imposto model;
	private TelaDeImposto view;
	
	//O construtor recebe as referencias das demais camadas

	public ImpostoController(Imposto model, TelaDeImposto view) {
		System.out.println("Construtor do Controller chamado");
		this.model = model;
		this.view = view;
	}
	
	//Método invocado quando o botão da View é invocado
	
	public void actionPerformed(ActionEvent e) {
		model.calcularImposto(view.getValor());
	}
	
	
}
