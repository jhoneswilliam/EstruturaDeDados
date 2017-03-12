package listasimplesmente;

import dados.*;

public class NoChar {
	private ItemChar info; // a declaração do tipo Item está no capitulo 1
	private NoChar prox;

	public NoChar (ItemChar elem){  // a variável elem contém os dados que serão armazenados
		this.info = elem;
		this.prox = null; // esta linha é opcional, pois o prox é automaticamente 
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
