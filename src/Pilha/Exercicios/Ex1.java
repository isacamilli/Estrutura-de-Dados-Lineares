package Pilha.Exercicios;
import Pilha.PilhaArray;
import java.util.Scanner;

public class Ex1{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        PilhaArray p = new PilhaArray(10,0);
        int num = 1;
        int x;

        while (num != 0) {

            System.out.println("\nEscolha um das opções apresentadas:");
            System.out.println("\n1 - Inserir número\n2 - Remover número");
            System.out.println("3 - Mostrar conteudo dentro da pilha\n0 - Fechar o programa\n");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.print("Escolha o número a inserir: ");
                    x = scanner.nextInt();
                    p.push(x);
                    System.out.println("\nNúmero inserido com sucesso");

                    break;

                case 2:
                    Object obj;
                    obj = p.pop();
                    System.out.println(obj +" extraido com sucesso");

                    break;

                case 3:

                    System.out.println("\nObjetos presentes na pilha:");
                    for (int i=0;i < p.size();i++){
                        System.out.println(p[i]);
                    }

                    break;
            
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        System.out.println("\nFechando o sistema...");

        scanner.close();

    }
}