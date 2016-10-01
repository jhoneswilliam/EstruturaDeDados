package Menu;

import Tipos.Item;
import Helpers.ItemMenu;
import Helpers.MenuConsole;
import java.util.Scanner;
import listaSimplesmente.ListaSimples;
import listaSimplesmente.No;

public class MenuConsoleListaSimples {

    private ListaSimples listaSimples;
    private Scanner scan;

    public MenuConsoleListaSimples(ListaSimples lista) {
        this.listaSimples = lista;
        this.scan = new Scanner(System.in);
    }

    public void Run() {
        Menu();
    }

    private boolean Menu() {

        MenuConsole menu = new MenuConsole();
        menu.Titulo("MENU PRINCIPAL");
        menu.AddItem(new ItemMenu(1, "Inserir"));
        menu.AddItem(new ItemMenu(2, "Remover"));
        menu.AddItem(new ItemMenu(3, "Pesquisar"));
        menu.AddItem(new ItemMenu(4, "Imprimir"));
        menu.AddItem(new ItemMenu(0, "Sair"));

        int op;
        boolean sair = false;

        do {
            op = menu.listarMenu();

            switch (op) {
                case 1:
                    MenuInserir();
                    break;
                case 2:
                    MenuRemover();
                    break;
                case 3:
                    pesquisarNo();
                    break;
                case 4:
                    ImprimirLista();
                    break;
                case 0:
                    System.out.println("Saindo!!!!");
                    return false;
                default:
                    System.out.println("Opção invalida");
            }
        } while (!sair);

        return sair;
    }

    private void MenuInserir() {
        MenuConsole menu = new MenuConsole();
        menu.Titulo("INSERIR");
        menu.AddItem(new ItemMenu(1, "Inserir primeiro"));
        menu.AddItem(new ItemMenu(2, "Inserir proximo"));
        menu.AddItem(new ItemMenu(3, "Inserir ultimo"));
        menu.AddItem(new ItemMenu(4, "Inserir k-essimo"));
        menu.AddItem(new ItemMenu(5, "Inserir antes de determinado"));
        menu.AddItem(new ItemMenu(6, "Inserir depois de determinado"));
        menu.AddItem(new ItemMenu(0, "Voltar"));

        int op;
        do {
            op = menu.listarMenu();
            switch (op) {
                case 1:
                    System.out.println(":::::::::INSERIR-PRIMEIRO:::::::::");
                    listaSimples.InserirPrimeiro(getNewItem());
                    break;
                case 2:
                    System.out.println(":::::::::INSERIR-PROXIMO::::::::::");
                    listaSimples.InserirProximo(getNewItem());
                    break;
                case 3:
                    System.out.println(":::::::::INSERIR-ULTIMO:::::::::::");
                    listaSimples.InserirUltimo(getNewItem());
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    private void MenuRemover() {
        MenuConsole menu = new MenuConsole();
        menu.Titulo("Remover");
        menu.AddItem(new ItemMenu(1, "Remover primeiro"));
        menu.AddItem(new ItemMenu(2, "Remover proximo"));
        menu.AddItem(new ItemMenu(3, "Remover ultimo"));
        menu.AddItem(new ItemMenu(4, "Remover k-essimo"));
        menu.AddItem(new ItemMenu(5, "Remover determinado"));
        menu.AddItem(new ItemMenu(6, "Remover antes de determinado"));
        menu.AddItem(new ItemMenu(7, "Remover depois de determinado"));
        menu.AddItem(new ItemMenu(0, "Voltar"));
        int op;
        do {
            op = menu.listarMenu();
            switch (op) {
                case 1:
                    //System.out.println(":::::::::Remover Primeiro:::::::::");                    

                    break;
                case 2:
                    //System.out.println(":::::::::Remover Proximo::::::::::");                    

                    break;
                case 3:
                    System.out.println(":::::::::Remover ultimo:::::::::::");
                    listaSimples.RemoverUltimo();
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println(":::::::::REMOVER-DETERMINADO::::::");
                    listaSimples.RemoverDeterminadoNo(getChave());
                    break;
                case 6:
                    System.out.println(":::REMOVER-ANTES-DE-DETERMINADO:::");
                    listaSimples.RemoverDeterminadoNo(getChave());
                    break;
                case 7:
                    System.out.println(":::REMOVER-DEPOIS-DE-DETERMINADO::");
                    listaSimples.RemoverDepoisDeterminadoNo(getChave());
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    public ListaSimples getListaSimples() {
        return listaSimples;
    }

    public void setListaSimples(ListaSimples listaSimples) {
        this.listaSimples = listaSimples;
    }

    /*funções internas*/
    private void pesquisarNo() {
        System.out.println(":::::::::::::Pesquisar::::::::::::");
        int chave;
        System.out.print("Digite uma chave :");
        chave = scan.nextInt();
        No nopesquisado = listaSimples.PesquisarNo(chave);
        if (nopesquisado != null) {
            System.out.println(nopesquisado.toString());
        } else {
            System.out.println("Nó não encontrado");
        }
    }

    private void ImprimirLista() {
        System.out.println(this.listaSimples.toString());
        System.out.println(this.listaSimples.getQuantNos() + " Nós");
    }

    private Item getNewItem() {
        System.out.print("Digite uma chave :");
        int chave = scan.nextInt();
        return new Item(chave);
    }

    private int getChave() {
        System.out.print("Insira a chave ==>");
        return scan.nextInt();
    }
}
