package Helpers;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsole {

    private String Titulo;
    private ArrayList<ItemMenu> items;
    private Scanner scan;
    
    public MenuConsole()
    {
        items = new ArrayList<>();
        scan = new Scanner(System.in);
    }

    public void AddItem(ItemMenu item) {
        items.add(item);
    }

    public int listarMenu() {
        System.out.println("==============" + getTitulo() + "=============");
        for (ItemMenu item : items) {
            System.out.println(item.toString());    
        }
        System.out.print("[Opção]==>");
        int op = scan.nextInt();
        System.out.println("..................................");
        return op;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void Titulo(String Titulo) {
        this.Titulo = Titulo;
    }
}
