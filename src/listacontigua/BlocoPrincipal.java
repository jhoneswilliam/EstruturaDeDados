package listacontigua;

import java.util.Scanner;

import dados.Item;

public class BlocoPrincipal {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("digite o tamanho m�ximo da lista");
		int tam = scan.nextInt();
		ListaContig lista = new ListaContig(tam);
		int valor;
		char opcao;
		do {
			System.out.println("Escolha uma Op��o:\n"+
					"1. Inserir N� no final\n"+
					"2. Localizar N�\n"+
					"3. Excluir N�\n"+
					"4. Exibir lista\n"+
					"5. Sair");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("Inserir um Valor no final da lista\n"
				+"Digite um valor");
				valor = scan.nextInt();
				if (! lista.inserirUltimo(new Item(valor))){
					System.out.println("Lista est� cheia");
				}
				break;
			case '2':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia");
				}
				else{
					System.out.println("Localizar um valor\nDigite o valor");
					valor = scan.nextInt();
					int pesqNo = lista.pesquisarNo(valor);
					if (pesqNo == lista.getFim()){
						System.out.println("o "+valor+
						" n�o foi encontrado");
					}else{
						System.out.println("o "+valor+
						" foi achado na lista na posi��o "+pesqNo);
					}
				}
				break;
			case '3':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia");
				}	
				else {
					System.out.println("Excluir um elemento da lista\n"
							+ "Digite um valor"); 
					valor = scan.nextInt();
					if (lista.removerNo(valor)){
						System.out.println("remo��o efetuada");
					}
					else{
						System.out.println("remo��o n�o efetuada,"+
						" valor n�o encontrado");
					}	
				}
				break;
			case '4':
				if (lista.�Vazia()){
					System.out.println("A lista est� vazia");
				}
				else{
					System.out.println("Exibir a lista"+lista.toString());
				}
				break;
			case '5':
				System.out.println("fim do programa");
				break;
			default: 
				System.out.println("op��o invalida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}

}
