package Fila;

public class testeFila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilaArray f =new FilaArray(10,0); //criando fila tamnho 1 e duplicação
		int num = 1;
		while (num != 0) {

			System.out.println("\nEscolha um das opções apresentadas:");
            System.out.println("\n1 - Inserir número\n2 - Remover número");
            System.out.println("3 - Mostrar conteudo dentro da pilha\n0 - Fechar o programa\n");
			
			switch (num) {
				case 0:
					f.enqueue(3);
					break;
			
				default:
					break;
			}
		}
	}

}
