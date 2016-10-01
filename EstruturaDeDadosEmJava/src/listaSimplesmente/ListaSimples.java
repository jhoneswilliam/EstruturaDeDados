package listaSimplesmente;

import Tipos.Item;

public class ListaSimples<T> {

    private No Prim;
    private No ult;
    private int quantNos;

    public ListaSimples() {
        this.Prim = null;
        this.ult = null;
        this.quantNos = 0;
    }

    public No getPrim() {
        return Prim;
    }

    public void setPrim(No prim) {
        this.Prim = prim;
    }

    public No getUlt() {
        return ult;
    }

    public void setUlt(No ult) {
        this.ult = ult;
    }

    public int getQuantNos() {
        return quantNos;
    }

    public void setQuantNos(int quantNos) {
        this.quantNos = quantNos;
    }

    ///funções pessoais abaixo
    public boolean estaVazia() {
        return this.Prim == null;
    }

    public void InserirPrimeiro(Item item) {
        No no = new No(item);
        no.setProx(this.Prim);
        if (estaVazia()) {
            this.ult = no;
        }
        this.Prim = no;
        this.quantNos++;
    }

    public void inserirKessimo() {

    }

    public void InserirProximo(Item item) {
        this.InserirUltimo(item);
    }

    public void InserirUltimo(Item item) {
        No no = new No(item);
        if (estaVazia()) {
            Prim = no;
        } else {
            ult.setProx(no);
        }
        ult = no;
        quantNos++;
    }

    public void LimparLista() {
        Prim = null;
        ult = null;
        quantNos = 0;
    }

    public No PesquisarNo(int chave) {
        No atual = this.Prim;
        while ((atual != null) && atual.getInfo().getChave() != (Object)chave) {
            atual = atual.getProx();
        }
        return atual;
        //se não tiver niguem que atenda a chave ele retorna o ultimo ?        
    }

    public boolean RemoverDeterminadoNo(int chave) {
        No anterior = this.Prim;
        No atual = this.Prim;
        while (atual != null && atual.getInfo().getChave() != (Object)chave) {
            anterior = atual;
            atual = atual.getProx();
        }
        if (atual != null) {
            if (atual == this.Prim) {
                if (this.Prim == this.ult) {
                    this.ult = null;
                }
                this.Prim = this.Prim.getProx();
            } else {
                anterior.setProx(atual.getProx());
            }
            quantNos--;
        }

        return false;
    }

    public boolean RemoverAntesDeterminadoNo(int chave) {
        return false;
    }

    public boolean RemoverDepoisDeterminadoNo(int chave) {
        No anterior = this.Prim;
        No atual = this.Prim;

        while (atual.getProx() != null && atual.getProx().getInfo().getChave() != (Object)chave) {
            anterior = atual;
            atual = atual.getProx();
        }
        
        if (atual != null) {
            anterior.setProx(atual.getProx());
            quantNos--;
            return true;
        }

        return false;
    }

    public void RemoverUltimo() {
        No atual = this.Prim;
        if (this.Prim != this.ult) {
            while (atual.getProx() != this.ult) {
                atual = atual.getProx();
            }
            atual.setProx(null);
            this.ult = atual;
            quantNos--;
        } else {
            this.Prim = null;
            this.ult = null;
            quantNos = 0;
        }
    }

    @Override
    public String toString() {
        No aux = this.Prim;
        String resultado = "";
        while (aux != null) {
            resultado += aux.getInfo().toString();
            aux = aux.getProx();
        }
        return resultado;
    }
}
