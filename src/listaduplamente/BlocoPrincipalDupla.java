package listaduplamente;
import java.util.Scanner;
import dados.Item;
public class BlocoPrincipalDupla {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		ListaDupla lista2 = new ListaDupla();
		int valor;
		NoDupla pesqNo = null;
		char opcao;
		do {
			opcao = menu();
			switch (opcao){
			case '1':
				System.out.println("Digite um valor");
				valor = scan.nextInt();
				lista.inserirPrimeiro(new Item(valor));
				break;
			case '2':
				System.out.println("Digite um valor");
				valor = scan.nextInt();
				lista.inserirUltimo(new Item(valor));
				break;
			case '3':
				System.out.println("Digite um valor");
				valor = scan.nextInt();
				pesqNo = lista.pesquisarNo(valor);
				if (pesqNo==null)
					System.out.println("o "+valor+" n�o foi achado");
				else
					System.out.println("o "+pesqNo.getInfo().getChave()+
							" foi achado na lista");
				break;
			case '4':
				System.out.println("Digite um valor");
				valor = scan.nextInt();
				if (lista.removerNo(valor))
					System.out.println("remo��o efetuada");
				else
					System.out.println("remo��o n�o efetuada");
				break;
			case '5':
				System.out.println("Exibir a lista\n"+
						lista.toString());
				break;
			case '6':
				System.out.println("fim do programa");
				break;
			default: 
				System.out.println("op��o invalida, tente novamente");
			}
		} while (opcao!='6');
		System.exit(0);
	}
	public static char menu(){
		System.out.println("Escolha uma Op��o:\n"+
				"1. Inserir N� no inicio\n"+
				"2. Inserir N� no fim\n"+
				"3. Localizar N�\n"+
				"4. Excluir N�\n"+
				"5. Exibir lista\n"+
				"6. Sair");
		return scan.next().charAt(0);
	}
}
