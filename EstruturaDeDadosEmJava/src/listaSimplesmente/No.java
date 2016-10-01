package listaSimplesmente;

import Tipos.IItem;

public class No<T> {

    private IItem info;
    private No prox;

    public No(IItem item) {
        this.info = item;
    }

    public IItem getInfo() {
        return info;
    }

    public void setInfo(IItem info) {
        this.info = info;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Info :" + this.getInfo().toString() + "\n"
                + "Prox :" + this.getProx().toString() + "\n";
    }
}
