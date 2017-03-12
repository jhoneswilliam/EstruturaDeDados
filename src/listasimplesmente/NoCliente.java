package listasimplesmente;

import dados.Clientes;

public class NoCliente {
	private Clientes info;
	private NoCliente prox;
	
	public NoCliente(Clientes elem){
		this.info = elem;
		this.prox = null;
	}

	public Clientes getInfo() {
		return info;
	}

	public void setInfo(Clientes info) {
		this.info = info;
	}

	public NoCliente getProx() {
		return prox;
	}

	public void setProx(NoCliente prox) {
		this.prox = prox;
	}
}
