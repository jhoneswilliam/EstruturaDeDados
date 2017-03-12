package listacontigua;

import java.util.Scanner;

import dados.Item;

public class BlocoPrincipal {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("digite o tamanho máximo da lista");
		int tam = scan.nextInt();
		ListaContig lista = new ListaContig(tam);
		int valor;
		char opcao;
		do {
			System.out.println("Escolha uma Opção:\n"+
					"1. Inserir Nó no final\n"+
					"2. Localizar Nó\n"+
					"3. Excluir Nó\n"+
					"4. Exibir lista\n"+
					"5. Sair");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("Inserir um Valor no final da lista\n"
				+"Digite um valor");
				valor = scan.nextInt();
				if (! lista.inserirUltimo(new Item(valor))){
					System.out.println("Lista está cheia");
				}
				break;
			case '2':
				if (lista.éVazia()){
					System.out.println("A lista está vazia");
				}
				else{
					System.out.println("Localizar um valor\nDigite o valor");
					valor = scan.nextInt();
					int pesqNo = lista.pesquisarNo(valor);
					if (pesqNo == lista.getFim()){
						System.out.println("o "+valor+
						" não foi encontrado");
					}else{
						System.out.println("o "+valor+
						" foi achado na lista na posição "+pesqNo);
					}
				}
				break;
			case '3':
				if (lista.éVazia()){
					System.out.println("A lista está vazia");
				}	
				else {
					System.out.println("Excluir um elemento da lista\n"
							+ "Digite um valor"); 
					valor = scan.nextInt();
					if (lista.removerNo(valor)){
						System.out.println("remoção efetuada");
					}
					else{
						System.out.println("remoção não efetuada,"+
						" valor não encontrado");
					}	
				}
				break;
			case '4':
				if (lista.éVazia()){
					System.out.println("A lista está vazia");
				}
				else{
					System.out.println("Exibir a lista"+lista.toString());
				}
				break;
			case '5':
				System.out.println("fim do programa");
				break;
			default: 
				System.out.println("opção invalida, tente novamente");
			}
		} while (opcao!='5');
		System.exit(0);
	}

}
