package listasimplesmente;
import java.util.Scanner;
import dados.Item;

public class MenuPrincipal {
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) {
		//instanciar a lista vazia
		ListaSimples lista = new ListaSimples();
		char opcao;
		int valor;
		Item item;
		do{
			System.out.println("escolha uma opção:\n"
					+ "1. inserir nó no final da lista\n"
					+ "2. pesquisar se um determinado valor"
					+ " existe na lista\n"
					+ "3. remover um determinado nó da lista\n"
					+ "4. sair do programa");
			opcao = scan.next().charAt(0);
			switch (opcao){
			case '1':
				System.out.println("digite um valor inteiro:");
				valor = scan.nextInt();
				item = new Item(valor);
				lista.inserirUltimo(item);
				System.out.println("operação realizada com sucesso!");
				break;
			case '2':
				System.out.println("digite o valor inteiro a"
						+ " ser procurado na lista:");
				valor = scan.nextInt();
				if (lista.pesquisarNo(valor)!=null){
					System.out.println("o valor está na lista");
				}else{
					System.out.println("o valor não está na lista");
				}
				break;
			case '3':
				System.out.println("digite o valor inteiro a"
						+ " ser removido da lista:");
				valor = scan.nextInt();
				if (lista.removerNó(valor)){
					System.out.println("o valor foi removido com sucesso!");
				}else{
					System.out.println("o valor não está na lista");
				}
				break;
			case '4':
				System.out.println("fim");
				break;
			default:
					System.out.println("opção inválida");
			}
		}while (opcao!='4');
	}


}
