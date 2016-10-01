package Menu;

import Tipos.Item;
import Helpers.ItemMenu;
import Helpers.MenuConsole;
import Pilha.PilhaContigua;
import Pilha.PilhaContigua;
import java.util.Scanner;

public class MenuConsolePilhaContigua {

    private PilhaContigua PilhaContigua;
    private Scanner scan;

    public MenuConsolePilhaContigua(PilhaContigua pilha) {
        this.PilhaContigua = pilha;
        this.scan = new Scanner(System.in);
    }

    public void Run() {
        Menu();
    }

    private boolean Menu() {

        MenuConsole menu = new MenuConsole();
        menu.Titulo("MENU PRINCIPAL PILHA");
        menu.AddItem(new ItemMenu(1, "Empilhar"));
        menu.AddItem(new ItemMenu(2, "Desempilhar"));
        ///////////////////////////////////////////EXERCICIOS
        menu.AddItem(new ItemMenu(3, "Inveter fase"));
        ///////////////////////////////////////////EXERCICIOS
        menu.AddItem(new ItemMenu(0, "Sair"));

        int op;
        boolean sair = false;

        do {
            op = menu.listarMenu();

            switch (op) {
                case 1:
                    Empilhar();
                    break;
                case 2:
                    Desempilhar();
                    break;
                ///////////////////////////////////////////EXERCICIOS
                case 3:
                    InverterFrase();
                    break;

                ///////////////////////////////////////////EXERCICIOS
                case 0:
                    System.out.println("Saindo!!!!");
                    return false;
                default:
                    System.out.println("Opção invalida!!!");
            }
        } while (!sair);

        return sair;
    }

    private void Empilhar() {
        System.out.print("Chave: ");
        int chave = scan.nextInt();
        this.PilhaContigua.Empilhar(new Item(chave));
    }

    private void Desempilhar() {
        System.out.print("Chave: ");
        Object item = this.PilhaContigua.Desempilhar();
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Esta vazia!!!");
        }
    }

    ///////////////////////////////////////////EXERCICIOS
    private void InverterFrase() {
        System.out.print("Frase: ");
        String frase = scan.nextLine();        
        
        this.PilhaContigua = new PilhaContigua(frase.length());
        
        for (int i = 0; i < frase.length(); i++) {
            PilhaContigua.Empilhar(frase.substring(i, i + 1));
        }

        System.out.print("Frase invertida: ");
        while (!PilhaContigua.EVazia()) {
            Object item = PilhaContigua.Desempilhar();
            if (item != null) {
                System.out.print(item.toString());
            }
        }
        System.out.println("");
    }
    ///////////////////////////////////////////EXERCICIOS
}
