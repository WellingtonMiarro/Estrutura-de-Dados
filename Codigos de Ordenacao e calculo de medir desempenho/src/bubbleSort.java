import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bubbleSort {
	public static int[] ordenacaoBolha(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
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
		        File arquivo = new File("C:/Users/Wellington/Casos de Teste/entrada1.txt"); //caminho
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
        for(int i = 0; i < NUM_REP; ++i) {
		System.out.println("BubbleSort executando com " + tamanho + " entradas: " + i + " a passagem");  
        	long t_inicial = System.nanoTime(); 
        	bubbleSort.ordenacaoBolha(vet);
        	long t_final = System.nanoTime();

		passou += (t_final - t_inicial);
		System.out.println("Tempo de execução: " + (t_final - t_inicial) + " ns"); 
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
       
        /*
         * LAÇO PARA EXIBIR VETOR ORDENADO 
        System.out.println("*** BUBBLE SORT ***");
		for (int i = 0; i < vet.length; i++) {
			System.out.printf("%3d ", vet[i]);
		}
		System.out.println();
		*/
	}
}
