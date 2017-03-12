package listacontigua;

import dados.Item;

public class ListaContig {
	private int fim;
	private Item [] info; // o tipo Item est· declarado no capÌtulo 1

	public ListaContig(int qte){
		this.fim = 0;
		this.info = new Item [qte];
	}
	public Item getInfo(int i){
		return this.info[i];
	}
	public void setInfo(int i, Item elem){
		this.info[i]=elem;
	}
	public int getFim(){
		return this.fim;
	}
	public void setFim(int _fim){
		this.fim = _fim;
	}
	public boolean ÈVazia (){
		return (this.fim == 0);
	}
	public boolean ÈCheia (){
		return (this.fim == this.info.length);
	}
	public boolean inserirUltimo (Item elem){
		if (this.ÈCheia()){
			return false;
		} else {
			this.info[this.fim]= elem;
			this.fim++;
			return true;
		}
	}
	public int pesquisarNo (int chave){
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		return i;
	}
	public boolean removerNo (int chave){
		int i = 0;
		while ((i < this.fim) && (this.info[i].getChave()!= chave)){
			i++;
		}
		if (i == this.fim){
			return false;
		}else{
			for (int j = i; j < this.fim-1 ;j++){
				this.info[j] = this.info[j+1];
			}
			this.fim--;	
			return true;
		}
	}	
	//lista 02 n∫2 letra a
	public String toString(){
		String msg="";
		for  (int i=0; i < this.fim; i++){
			msg += this.info[i].getChave()+"\n";
		}
		return msg;
	}
	//lista 02 n∫2 letra b
	public String pesquisarPosicao (int chave){
		int i = 0;
		while ((i < this.fim)&&(this.info[i].getChave()!=
				chave)){
			i++;
		}
		if (i==this.fim){
			return "valor n„o encontrado";
		} else{
			return "valor est· na posiÁ„o "+i;
		}
	}

	//lista 02 n∫2 letra c
	public boolean inserirAposDeterminado (int chave, Item novo){
		if (this.ÈCheia()||(this.ÈVazia())){
			return false;
		}else{


			int i = 0;
			while ((i < this.fim) && (this.info[i].getChave()!= chave)){
				i++;
			}
			if (i==this.fim){
				return false;
			}else{
				i++;
				for (int j=this.fim;j>i;j--){
					this.info[j]=this.info[j-1];
				}
				this.info[i]=novo;
				this.fim++;
				return true;
			}
		}

	}
	//lista 02 n∫2 letra d
	public boolean removerDeterminadoNo(int chave){
		if (this.ÈVazia()){
			return false;
		}else{
			int i = 0;
			while ((i < this.fim) &&
					(this.info[i].getChave()!= chave)){
				i++;
			}
			if (i==this.fim){
				return false;
			}else{
				for (int j=i;j<this.fim-1;j++){
					this.info[j]=this.info[j+1];
				}
				this.fim--;
				return true;
			}
		}

	}
	//lista 02 n∫2 letra e
	public void removerTodosDeterminadoNo(int chave){
		if (!this.ÈVazia()){
			for (int i=0;i< this.fim;i++){
				if (this.info[i].getChave()==chave){
					for (int j=i;j<this.fim-1;j++){
						this.info[j]=this.info[j+1];
					}
					this.fim--;
					i--;
				}
			}
		}

	}
	//lista 02 n∫3
	public ListaContig transferirValores(){
		ListaContig novo = new ListaContig(this.fim);
		if (this.ÈVazia()){
			return novo;
		}else{
			for (int i=0; i<this.fim; i++){
				if (this.info[i].getChave()>100){
					novo.setInfo(novo.fim,this.getInfo(i));
					novo.fim++;
					//ou
					//novo.inserirUltimo(this.getInfo(i));
					for (int j=i;j<this.fim-1;j++){
						this.info[j]=this.info[j+1];
					}
					this.fim--;
					i--;
				}
			}
			return novo;
		}
	}
	//outra soluÁ„o usando while
	public ListaContig removeMaiores100 (){
		ListaContig nova = new ListaContig(this.fim);
		int i = 0;
		int j;
		while (i < this.fim){
			if (this.info[i].getChave()> 100){
				nova.inserirUltimo(this.info[i]);
				for (j = i; j<this.fim-1 ;j++){
					this.info[j]= this.info[j+1];
				}
				this.fim--;
			}else{
				i++;
			}
		}
		return nova;
	}	

	//lista 02 n∫4
	public void eliminarRepetidos(int x){
		if (!this.ÈVazia()){
			int i=0;
			while ((i<this.fim)&&(this.info[i].getChave()!=x)){
				i++;
			}
			if (i!=this.fim){
				i++;
				while (i<this.fim){
					if (this.info[i].getChave()==x){
						for (int j=i; j<this.fim-1;j++){
							this.info[j]=this.info[j+1];
						}
						this.fim--;
					}else{
						i++;
					}
				}
			}
		}
	}
	//lista 02 n∫5
	public boolean duplicarDado(int x){
		if ((this.ÈCheia())||(this.ÈVazia())){
			return false;
		}else{
			for (int i=0; i<this.fim; i++){
				if (this.info[i].getChave()==x){
					if (this.ÈCheia()){
						return false;
					}else{
						for(int j=this.fim;j>i+1;j--){
							this.info[j]=this.info[j-1];
						}
						this.info[i+1]=this.info[i];
						this.fim++;
						i++;
					}
				}
			}
			return true;
		}
	}
	//lista 02 n∫6
	public int copiarDados(ListaContig l2){
		int cont=0;
		for (int i=0; i<this.fim && !l2.ÈCheia();i++){
			if (this.info[i].getChave()%2==0){
				l2.inserirUltimo(new Item(this.info[i].getChave()));
				cont++;
			}
		}
		return cont;
	}
	//lista 02 n∫7 letra a
	public boolean inserirAntesDeterminado (int chave, Item novo){
		if (this.ÈCheia()||(this.ÈVazia())){
			return false;
		}else{
			int i = 0;
			while ((i < this.fim) && (this.info[i].getChave()!= chave)){
				i++;
			}
			if (i==this.fim){
				return false;
			}else{
				for (int j=this.fim;j>i;j--){
					this.info[j]=this.info[j-1];
				}
				this.info[i]=novo;
				this.fim++;
				return true;
			}
		}
	}
	//lista 02 n∫7 letra B
	public boolean removerDeterminadoNome(int chave){
		if (this.ÈVazia()){
			return false;
		}else{
			int i = 0;
			while ((i < this.fim) && (this.info[i].getChave()!= chave)){
				i++;
			}
			if (i==this.fim){
				return false;
			}else{
				for (int j=i;j<this.fim-1;j++){
					this.info[j]=this.info[j+1];
				}
				this.fim--;
				return true;
			}
		}
	}
}
