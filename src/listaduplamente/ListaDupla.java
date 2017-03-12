package listaduplamente;

import dados.Item;

public class ListaDupla {

    private NoDupla prim;
    private NoDupla ult;
    private int quantNos;

    public ListaDupla() {
        this.prim = null;
        this.ult = null;
        this.quantNos = 0;
    }

    public int getQuantNos() {
        return this.quantNos;
    }

    public NoDupla getPrim() {
        return this.prim;
    }

    public NoDupla getUlt() {
        return this.ult;
    }

    public void setQuantNos(int valorNovo) {
        this.quantNos = valorNovo;
    }

    public void setPrim(NoDupla novoNo) {
        this.prim = novoNo;
    }

    public void setUlt(NoDupla novoNo) {
        this.ult = novoNo;
    }

    public boolean eVazia() {
        return (this.prim == null);
    }

    public void inserirPrimeiro(Item elem) {
        NoDupla novoNo = new NoDupla(elem);
        if (this.eVazia()) {
            this.ult = novoNo;
        } else {
            novoNo.setProx(this.prim);
            this.prim.setAnt(novoNo);
        }
        this.prim = novoNo;
        this.quantNos++;
    }

    public void inserirUltimo(Item elem) {
        NoDupla novoNo = new NoDupla(elem);
        if (this.eVazia()) {
            this.prim = novoNo;
        } else {
            novoNo.setAnt(this.ult);
            this.ult.setProx(novoNo);
        }
        this.ult = novoNo;
        this.quantNos++;
    }

    public NoDupla pesquisarNo(int chave) {
        NoDupla atual = this.prim;
        while ((atual != null) && (atual.getInfo().getChave() != chave)) {
            atual = atual.getProx();
        }
        return atual;
    }

    public boolean removerNo(int chave) {
        NoDupla atual = this.prim;
        while ((atual != null) && (atual.getInfo().getChave() != chave)) {
            atual = atual.getProx();
        }
        if (atual == null) {
            return false;
        } else if (atual == this.prim) {
            this.prim = prim.getProx();
            if (this.prim == null) {
                this.ult = null;
            } else {
                this.prim.setAnt(null);
            }
        } else if (atual == this.ult) {
            this.ult = this.ult.getAnt();
            this.ult.setProx(null);
        } else {
            atual.getProx().setAnt(atual.getAnt());
            atual.getAnt().setProx(atual.getProx());
        }
        this.quantNos--;
        return true;
    }

    public String toString() {
        String msg = "";
        NoDupla atual = this.prim;
        while (atual != null) {
            msg += atual.getInfo().getChave() + "\n";
            atual = atual.getProx();
        }
        return msg;
    }

    //lista03 n�mero 6 letra a

    public boolean concatenarListas(ListaDupla L2) {
        if (L2.eVazia()) {
            return false;
        } else {
            if (this.eVazia()) {
                this.prim = L2.prim;
                this.ult = L2.ult;
                this.quantNos = L2.quantNos;
            } else {
                this.ult.setProx(L2.prim);
                L2.prim.setAnt(this.ult);
                this.ult = L2.ult;
                this.quantNos += L2.quantNos;
            }
        }
        L2.prim = null;
        L2.ult = null;
        L2.quantNos = 0;
        return true;
    }

    //lista03 n�mero 6 letra b

    public ListaDupla partirLista() {
        if ((this.eVazia()) || (this.quantNos == 1)) {
            return null;
        } else {
            ListaDupla nova = new ListaDupla();
            NoDupla atual = this.prim;
            for (int i = 1; i < this.quantNos / 2; i++) {
                atual = atual.getProx();
            }
            nova.prim = atual.getProx();
            nova.ult = this.ult;
            nova.prim.setAnt(null);
            atual.setProx(null);
            this.ult = atual;
            nova.quantNos = this.quantNos - (this.quantNos / 2);
            this.quantNos = this.quantNos / 2;
            return nova;
        }
    }

    //lista 03 numero 7

    public Item procurarMaior() {
        if (this.eVazia()) {
            return null;
        } else {
            Item maior = this.prim.getInfo();
            NoDupla atual = this.prim.getProx();
            while (atual != null) {
                if (atual.getInfo().getChave() > maior.getChave()) {
                    maior = atual.getInfo();
                }
                atual = atual.getProx();
            }
            return maior;
        }
    }

    //lista 03 numero 8
    public double calcularMedia() {
        if (this.eVazia()) {
            return 0;
        } else {
            int soma = 0;
            NoDupla atual = this.prim;
            while (atual != null) {
                soma += atual.getInfo().getChave();
                atual = atual.getProx();
            }
            return soma / this.quantNos;
        }
    }

    //lista 03 numero 9

    public void removerRepetidos() {
        if (!this.eVazia()) {
            NoDupla atual = this.prim;
            NoDupla atual2;
            while (atual.getProx() != null) {
                atual2 = atual.getProx();
                while (atual2 != null) {
                    if (atual.getInfo().getChave()
                            == atual2.getInfo().getChave()) {
                        if (atual2 == this.ult) {
                            this.ult = atual2.getAnt();
                            this.ult.setProx(null);
                        } else {
                            atual2.getProx().setAnt(atual2.getAnt());
                            atual2.getAnt().setProx(atual2.getProx());
                        }
                        this.quantNos--;
                    }
                    atual2 = atual2.getProx();
                }
                atual = atual.getProx();
            }
        }
    }

    // outra solu��o

    public void removerRepetidos2() {
        NoDupla atual = this.prim;
        NoDupla aux;
        while (atual != null) {
            aux = atual.getProx();
            while (aux != null) {
                if (atual.getInfo().getChave() == aux.getInfo().getChave()) {
                    this.removerNoRepetido(aux);
                }
                aux = aux.getProx();
            }
            atual = atual.getProx();
        }
    }

    public void removerNoRepetido(NoDupla aux) {
        if (aux == this.ult) {
            this.ult = this.ult.getAnt();
            this.ult.setProx(null);
        } else {
            aux.getProx().setAnt(aux.getAnt());
            aux.getAnt().setProx(aux.getProx());
        }
        this.quantNos--;
    }
}
