package listasimplesmente;

import dados.*;

public class ListaSimplesChar {
	private NoChar prim;
	private NoChar ult;
	private int quantNos;
	//construtor da classe
	public ListaSimplesChar(){
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public NoChar getPrim(){
		return this.prim;
	}
	public NoChar getUlt(){
		return this.ult;
	}
	public void setQuantNos(int novoValor){
		this.quantNos = novoValor;
	}
	public void setPrim(NoChar novoNo){
		this.prim = novoNo;
	}
	public void setUlt(NoChar novoNo){
		this.ult = novoNo;
	}
	public boolean éVazia (){
		return (this.prim == null);
	}
	public void inserirPrimeiro(ItemChar elem){
		NoChar novoNo = new NoChar (elem);
		if (this.éVazia()){
			this.ult = novoNo;
}
		novoNo.setProx(this.prim);
		this.prim = novoNo;
		this.quantNos++;
	}
	public void inserirUltimo (ItemChar elem){
		NoChar novoNo = new NoChar (elem);
		if (this.éVazia()){
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	public NoChar pesquisarNo (int chave){
		NoChar atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)){
			atual = atual.getProx();
		}	
		return atual;
	}
	public boolean removerNo (int chave) {
		NoChar atual = this.prim;
		NoChar ant = null;
		if (this.éVazia()){
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
				NoChar atual = this.prim;
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
	//mostra todo o conteúdo da lista
	public String toString(){
		String msg = "";
		NoChar atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().getChave()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
	public boolean inserirKesimo(int k, ItemChar elem){
		if ((this.éVazia()) || (k>this.quantNos)){
			return false;
		}else{
			NoChar atual = this.prim;
			NoChar novoNo = new NoChar(elem);//instanciou o nó na dinâmica
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
	//lista 01 número 16
	public boolean verificarIdentica(ListaSimplesChar L2){
		if (this.quantNos!=L2.quantNos){
			return false;
		}else{
			NoChar atual1 = this.prim;
			NoChar atual2 = L2.prim;
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
	public ListaSimplesChar copy(ListaSimplesChar l2, int index,
		int count){
		if ((index>l2.quantNos)||(index+count-1>l2.quantNos)){
			return null;
		}else{
			ListaSimplesChar  nova = new ListaSimplesChar();
			NoChar atual = l2.prim;
			for (int i=1;i<index;i++){
				atual = atual.getProx();
			}
			for (int i=1;i<=count;i++){
				nova.inserirUltimo(new ItemChar(atual.getInfo().getChave()));
				atual = atual.getProx();
			}
			return nova;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
