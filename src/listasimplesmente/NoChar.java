package listasimplesmente;

import dados.*;

public class NoChar {
	private ItemChar info; // a declara��o do tipo Item est� no capitulo 1
	private NoChar prox;

	public NoChar (ItemChar elem){  // a vari�vel elem cont�m os dados que ser�o armazenados
		this.info = elem;
		this.prox = null; // esta linha � opcional, pois o prox � automaticamente 
							//definido como null
	}
	public ItemChar getInfo (){
		return this.info;
	}
	public void setInfo(ItemChar elem){
		this.info = elem;
	}
	public NoChar getProx(){
		return this.prox;
	}
	public void setProx(NoChar novoNo){
		this.prox = novoNo;
	}

}
