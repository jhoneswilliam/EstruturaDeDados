package listasimplesmente;

import dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;
	//construtor da classe
	public ListaSimples(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean éVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(Item elem){
		No novoNo = new No (elem);
		if (this.éVazia()){
			this.ult = novoNo;
		}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (Item elem){
		No novoNo = new No (elem);
		if (this.éVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo (int chave) {
		No atual = this.prim;
		No ant = null;
		if (éVazia()){
			return false;
		} else {
			while ((atual != null)&&(atual.getInfo().getChave()!= chave)){
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null){
				return false;
			}
			else{
				if (atual == this.prim){
					if (this.prim == this.ult){
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult){
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}
	//outra forma de escrever o método para remover determinado Nó
	public boolean removerNó(int x){
		if (this.éVazia()){
			return false;
		}else{
			if (this.prim.getInfo().getChave()==x){
				if (this.prim.getProx()==null){//se for único nó da lista
					this.ult = null;
				}
				//remover o primeiro nó da lista
				this.prim = this.prim.getProx();
				this.quantNos--;
				return true;
			}else{
				No atual = this.prim;
				while ((atual.getProx()!=null)&&
						(atual.getProx().getInfo().getChave()!=x)){
					atual = atual.getProx();
				}
				if (atual.getProx()==null){//não achou o valor na lista
					return false;
				}else{
					if (atual.getProx()==this.ult){//se for o último nó
						atual.setProx(null);
						this.ult = atual;
					}else{	//remove o nó no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
					this.quantNos--;
					return true;
				}
			}
		}
	}
	//lista 01 número 12 letra a
	public String toString(){
		String msg = "";
		No atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}

	public boolean inserirKesimo(int k, Item elem){
		if ((this.éVazia()) || (k>this.quantNos)){
			return false;
		}else{
			No atual = this.prim;
			No novoNo = new No(elem);//instanciou o nó na dinâmica
			if (k==1){//inserir antes do primeiro
				novoNo.setProx(this.prim);
				this.prim =  novoNo;
			}else{
				for (int i=1; i< k-1 ;i++){
					atual = atual.getProx();//caminha na lista
				}
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
			}
			this.quantNos++;
			return true;
		}
	}
	//lista 01 número 12 letra b
	public String procurarPosicaoX (int x){
		if (this.éVazia()){
			return "Lista Vazia";
		}else{
			No atual =this.prim;
			int posicao=1;
			while ((atual!=null) && (atual.getInfo().getChave()!=x)){
				atual = atual.getProx();
				posicao++;
			}
			if (atual == null){
				return "o valor não foi encontrado";
			}else{
				return "o valor está na posição "+posicao;
			}
		}
	}
	//lista 01 número 12 letra c
	public void removerTodosNos5(){
		if (!this.éVazia()){
			while ((this.prim!=null)&&
					(this.prim.getInfo().getChave()==5)){
				this.prim = this.prim.getProx();
				this.quantNos--;	
			}
			if (this.prim!=null){
				No atual = this.prim;
				while (atual.getProx()!=null){
					if (atual.getProx().getInfo().getChave()==5){
						if (atual.getProx()==this.ult){//remove o ultimo nó da lista
							atual.setProx(null);
							this.ult = atual;
						}else{//remove o nó no meio da lista
							atual.setProx(atual.getProx().getProx());
						}
						this.quantNos--;
					}else{
						atual = atual.getProx();
					}
				}
			}
		}
	}
	//lista 01 número 13
	public double calcularMedia(){
		if (this.éVazia()){
			return 0.0;
		}else{
			double soma=0;
			No atual = this.prim;
			/*while (atual!=null){
				soma += atual.getInfo().getChave();
				atual = atual.getProx();
			}*/
			for (int i=1; i<=this.quantNos; i++){
				soma += atual.getInfo().getChave();
				atual = atual.getProx();
			}
			return (soma/this.quantNos);
		}
	}
	//lista 01 número 14
	public int pesquisarListaOrdenada (int chave){
		int posicao=1;
		No atual = this.prim;
		while ((atual != null) && (chave > atual.getInfo().getChave())){
			atual = atual.getProx();
			posicao++;
		}
		if ((atual==null)||(atual.getInfo().getChave() > chave)){
			return -1;
		}else{
			return posicao;
		}
	}
	//lista 01 número 15
	//realizada no quadro
	
	//lista 01 número 16
	public boolean verificarIdentica(ListaSimples L2){
		if (this.quantNos!=L2.quantNos){
			return false;
		}else{
			No atual1 = this.prim;
			No atual2 = L2.prim;
			while (atual1!= null){
				if (atual1.getInfo().getChave()!=
						atual2.getInfo().getChave()){
					return false;
				}
				atual1 = atual1.getProx();
				atual2 = atual2.getProx();
			}
			return true;
		}
	}
	
	//lista 01 número 17
	//está na classe ListaSimplesChar
	
	
	//lista 01 número 18
	public int trocarNumeros(int n1, int n2){
		int cont=0;
		No atual = this.prim;
		while (atual!= null){
			if (atual.getInfo().getChave()==n1){
				atual.getInfo().setChave(n2);
				cont++;
			}
			atual = atual.getProx();
		}
		return cont;
	}
	//lista 01 número 19
	public int procurarValor(int x){
		if (this.éVazia()){
			return 0;
		}else{
			int cont=0;
			No atual = this.prim;
			while (atual!=null){
				if (atual.getInfo().getChave()==x){
					cont++;
				}
				atual = atual.getProx();
			}
			if (cont==0){
				No novoNo = new No(new Item(x));
				this.ult.setProx(novoNo);
				this.ult = novoNo;
				this.quantNos++;
				cont++;
			}
			return cont;
		}
	}
	//lista 01 número 20
	public boolean procurarLista(ListaSimples l2){
		if ((this.éVazia())||(l2.éVazia())||(this.quantNos>l2.quantNos)){
			return false;
		}else{
			No atual = this.prim;
			No atual2;
			boolean achou=false;
			while (atual!=null){
				atual2 = l2.prim;
				achou=false;
				while ((atual2!=null)&&(!achou)){
					if (atual.getInfo().getChave()==atual2.getInfo().getChave()){
						achou = true;
					}
					atual2 = atual2.getProx();
				}
				if (!achou){
					return false;
				}else{
					atual= atual.getProx();
				}
			}
			return true;
		}
	}
	//lista 01 número 21
	public void removerPartido(int chave){
		if (!this.éVazia()){
			while ((this.prim!=null)&&(this.prim.getInfo().getChave()==chave)){
				this.prim = this.prim.getProx();
				this.quantNos--;	
			}
			if (this.prim==null){
				this.ult=null;
			}else{
				No atual = this.prim;
				while (atual.getProx()!=null){
					if (atual.getProx().getInfo().getChave()==chave){
						if (atual.getProx()==this.ult){    //remove o último nó da lista
							atual.setProx(null);
							this.ult = atual;
						}else{      //remove o nó no meio da lista
							atual.setProx(atual.getProx().getProx());
						}
						this.quantNos--;
					}else{
						atual = atual.getProx();
					}
				}
			}
		}
	}
}
