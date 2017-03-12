package listasimplesmente;
import java.util.Scanner;

import dados.Item;
import dados.ItemChar;

public class MenuPrincipalChar {
	static Scanner scan = new Scanner (System.in);

	public static void main(String[] args) {
		//instanciar a lista vazia
		ListaSimplesChar lista1 = new ListaSimplesChar();;
		ListaSimplesChar lista2 = new ListaSimplesChar();
		char opcao;
		char valor;
		ItemChar item;
		do{
			System.out.println("escolha uma op��o:\n"
					+ "1. inserir n� no final da lista2\n"
					+ "2. copiar lista2 para lista1\n"
					+ "3. mostrar lista1\n"
					+ "4. sair do programa");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("digite uma letra:");
				valor = scan.next().charAt(0);
				item = new ItemChar(valor);
				lista2.inserirUltimo(item);
				System.out.println("opera��o realizada com sucesso!");
				break;
			case '2':
				lista1 = new ListaSimplesChar();
				int index, count;
				System.out.println("digite o valor do index");
				index = scan.nextInt();
				System.out.println("digite a quantidade de n�s");
				count = scan.nextInt();
				lista1 = lista1.copy(lista2, index, count);
				if (lista1==null){
					System.out.println("opera��o n�o realizada");
				}
				break;
			case '3':
				if (lista1!=null){
					System.out.println(lista1.toString());
				}else{
					System.out.println("lista1 vazia");
				}
				break;
			case '4':
				System.out.println("fim");
				break;
			default:
				System.out.println("op��o inv�lida");
			}
		}while (opcao!='4');
	}


}
