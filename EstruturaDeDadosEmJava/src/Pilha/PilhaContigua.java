package Pilha;

import Tipos.Item;

public class PilhaContigua<T> {

    private int Topo;
    private T[] Info;

    public PilhaContigua(int tamanho) {
        this.Info = (T[]) new Object[tamanho];
        this.Topo = 0;
    }

    public boolean Empilhar(T item) {
        if (this.Topo < this.Info.length) {
            this.Info[this.Topo] = item;
            this.Topo++;
            return true;
        }

        return false;
    }

    public T Desempilhar() {
        if (!EVazia()) {
            return this.Info[--this.Topo];//hehe Guambiarra
        }

        return null;
    }

    public boolean EVazia() {
        return this.Topo == 0;
    }
}
