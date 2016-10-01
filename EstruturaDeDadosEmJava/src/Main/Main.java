package Main;

import Menu.MenuConsolePilhaContigua;
import Pilha.PilhaContigua;

public class Main {

    public static void main(String[] args) {
        /* 
         ListaSimples listaSimples = new ListaSimples(); 
         MenuListaSimples menuListaSimples = new MenuListaSimples(listaSimples);
         menuListaSimples.Run();
         */

        PilhaContigua pilhaContigua = new PilhaContigua(10);
        MenuConsolePilhaContigua menuPilhaContigua = new MenuConsolePilhaContigua(pilhaContigua);
        menuPilhaContigua.Run();

    }

}
