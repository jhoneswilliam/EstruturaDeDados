package Tipos;

public class Item implements IItem {

    private int Chave;

    public Object getChave() {
        return Chave;
    }

    public void setChave(int Chave) {
        this.Chave = Chave;
    }

    public Item(int chave) {
        this.setChave(chave);
    }

    @Override
    public String toString() {
        return getChave() + "\n";
    }

    @Override
    public void setChave(Object Chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
