package pilhacontigua;

import listaduplamente.ListaDupla;
import listaduplamente.NoDupla;
import dados.Item;
import dados.ItemChar;

public class PilhaContig {
	private Item [] info;
	private int topo;

	public PilhaContig(int qte){
		this.topo = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(){
		return this.info[this.topo-1];
	}
	public int getTopo(){
		return this.topo;
	}
	public boolean ÈVazia (){
		return (this.topo == 0);
	}
	public boolean ÈCheia (){
		return (this.topo == this.info.length);
	}
	public boolean empilhar (Item elem){
		if (this.ÈCheia()) 
			return false;
		else {
			this.info[this.topo]= elem;
			this.topo++;
			return true;
		}	
	}
	public Item desempilhar(){
		if (this.ÈVazia())
			return null;
		else{
			this.topo--;
			return  this.info[this.topo];
		}
	}	
	//lista 04 numero 1
	public String inverterPalavra(String palavra){
		PilhaContig p = new PilhaContig(palavra.length());
		Item letra;
		for (int i=0; i< palavra.length();i++){
			letra = new Item(palavra.charAt(i));
			p.empilhar(letra);
		}
		palavra ="";
		while (!p.ÈVazia()){
			palavra += p.desempilhar().getChave();
		}
		return palavra;
	}
	
	/*lista 04 numero 1   OUTRA SOLU«√O
	public String inverterPalavra2(String frase){
		if (this.info.length<=frase.length()){
			this.topo=0;
			for (int i=0;i<frase.length();i++){
				this.empilhar(new ItemChar(frase.charAt(i)));  //erro devido o empilhar est· recebendo um inteiro
			}											//teria que criar nova classe de pilha usando tipo char
			frase="";
			while (!this.ÈVazia()){
				frase+= this.desempilhar().getChave();
			}
		}else{
			frase = "n„o È possÌvel inverter";
		}
		return frase;
	}*/
	
	//lista 04 numero 2
	public void removerMaior10(){
		PilhaContig aux = new PilhaContig(this.topo);
		Item valor;
		while (!this.ÈVazia()){
			valor = this.desempilhar();
			if (valor.getChave()<=10){
				aux.empilhar(valor);
			}
		}
		while (!aux.ÈVazia()){
			this.empilhar(aux.desempilhar());
		}
	}
	//lista 04 numero 3
	public int s„oIdenticas (PilhaContig p){
		PilhaContig aux1 = new PilhaContig(this.topo);
		PilhaContig aux2 = new PilhaContig(p.topo);
		int resp= 1;
		if (this.topo!= p.topo){
			resp = 0;
		}else{
			while ((this.topo !=0) && (resp==1)){
				if (this.info[this.topo-1].getChave()!=p.info[p.topo-1].getChave()){
					resp = 0;
				}else{
					aux1.empilhar(this.desempilhar());
					aux2.empilhar(p.desempilhar());
				}
			}
			while (aux1.topo!=0){
				this.empilhar(aux1.desempilhar());
				p.empilhar(aux2.desempilhar());
			}
		}
		return resp;
	}
	//lista 04 numero 5
	
	//lista 04 numero 7
	public void tranferirPilhaParaDuplamente(ListaDupla lista){
		Item no;
		while (!this.ÈVazia()){
			no = this.desempilhar();
			NoDupla novoNo = new NoDupla(no);
			if (lista.ÈVazia()){
				lista.setPrim(novoNo);
				lista.setUlt(novoNo);
			}else{
				novoNo.setProx(lista.getPrim());
				lista.getPrim().setAnt(novoNo);
				lista.setPrim(novoNo);
			}
			lista.setQuantNos(lista.getQuantNos()+1);
		}
	}
	
	//lista 04 numero 8
	
	//lista 04 numero 9
	
	//lista 04 numero 10
	
		
}
