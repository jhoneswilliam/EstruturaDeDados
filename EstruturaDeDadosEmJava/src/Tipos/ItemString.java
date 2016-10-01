package Tipos;

public class ItemString {

    private String Chave;

    public String getChave() {
        return Chave;
    }

    public void setChave(String Chave) {
        this.Chave = Chave;
    }

    public ItemString(String chave) {
        this.setChave(chave);
    }

    @Override
    public String toString() {
        return getChave() + "\n";
    }
}
