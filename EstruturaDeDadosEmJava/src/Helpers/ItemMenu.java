package Helpers;

public class ItemMenu {

    public ItemMenu(int valor, String descricao) {
        this.Valor = valor;
        this.Descricao = descricao;
    }

    public int Valor;
    public String Descricao;

    @Override
    public String toString() {
        return "[" + Valor + "]" + Descricao;
    }
}
