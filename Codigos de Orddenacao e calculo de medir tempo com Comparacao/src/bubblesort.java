import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bubblesort {
	private static int cont = 0;
	public static int[] ordenacaoBolha(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				cont++;
				if (vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
		}
		return vetor;
	}
	public static void main(String[] args) {
		
		final int NUM_REP = 5;
		int[] vet = null;
		int tamanho = 0; 
		try {
		        File arquivo = new File("C:/Users/Wellington/Casos de Teste/entrada1.txt");
        		Scanner leitor = new Scanner(arquivo);
        
			 tamanho = leitor.nextInt();  
			vet = new int[tamanho];

		        for (int i = 0; i < tamanho; i++) {
				vet[i] = leitor.nextInt();  
			}

		        leitor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Deu ruim");
			System.exit(1);
		}
		
		long passou = 0;
		int totalTrocas = 0;
        for(int i = 0; i < NUM_REP; ++i) {
		System.out.println("BubbleSort executando com " + tamanho + " entradas: " + i + " a passagem");  
        	long t_inicial = System.nanoTime(); //System.nanoTime(); *nanosegundos
        	bubblesort.ordenacaoBolha(vet);
        	long t_final = System.nanoTime();
        
        System.out.println("Quantidade de compara��es: "+ cont);	
        totalTrocas += cont;
        cont=0;
		passou += (t_final - t_inicial);
		System.out.println("Tempo de execu��o: " + (t_final - t_inicial) + " ns"); 
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
        System.out.println("Total de compara��es: "+ totalTrocas);
        
        
         /* LA�O PARA EXIBIR VETOR ORDENADO 
        System.out.println("*** BUBBLE SORT ***");
		for (int i = 0; i < vet.length; i++) {
			System.out.printf("%3d ", vet[i]);
		}
		System.out.println();
		*/
		
	}
}