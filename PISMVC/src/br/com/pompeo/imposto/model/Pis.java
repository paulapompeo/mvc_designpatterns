package br.com.pompeo.imposto.model;

import java.util.Observable;

import br.com.pompeo.imposto.util.AliquotaSingleton;

//O model é um Observable
//A Classe Pis da camada Model nao possui referencia a View ou ao Controller
//Ao implementar Imposto, teremos maior flexibilidade no Controller

public class Pis extends Observable implements Imposto {

	//Recebe do Singleton o valor da propriedade aliquotaPis
	final float ALIQUOTA = Float.parseFloat(AliquotaSingleton.getInstance().getProperty("aliquotaPis"));
	float valorDoPis = 0;
	
	public Pis() {
		System.out.println("Construtor do Model chamado");
	}
	
	public float getALIQUOTA() {
		return ALIQUOTA;
	}

	public float getValorDoPis() {
		return valorDoPis;
	}
	
	public void calcularImposto(float valor) {
		valorDoPis = valor * ALIQUOTA;
		//setChanged Altera o estado interno do objeto
		//para true, foi houve uma alteracao no estado do valorPis
		setChanged();
		//Os observadores deve ser notificados
		//Envia o valor do PIS como parte da mensagem de
		//notificacao para a View que é um Observer
		notifyObservers(valorDoPis);
	}
	
	@Override
	public String toString() {
		return "Pis [ALIQUOTA = " + ALIQUOTA + ", valorDoPis=" + valorDoPis + "]";
	}

}
