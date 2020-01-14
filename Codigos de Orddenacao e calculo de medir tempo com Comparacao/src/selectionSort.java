import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class selectionSort {
	private static int cont = 0;
	public static int[] ordenacaoSelection(int[] vetor) {
	    int menor;
	    int indiceMenor;
        for (int i = 0; i < vetor.length - 1; i++) {
            
            menor = vetor[i];
            indiceMenor = i;

           
            for (int j = i + 1; j < vetor.length; j++){
            	cont++;
            	if (vetor[j] < menor){
                    menor = vetor[j];
                    indiceMenor = j;
       
                }
            }
            vetor[indiceMenor] = vetor[i];
            vetor[i] = menor;
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
		
		int totalTrocas = 0;
		long passou = 0;
        for(int i = 0; i < NUM_REP; ++i) {
		System.out.println("SelectionSort executando com " + tamanho + " entradas: " + i + " a passagem");  
        	long t_inicial = System.nanoTime(); 
        	selectionSort.ordenacaoSelection(vet);
        	long t_final = System.nanoTime();

    	System.out.println("Quantidade de comparações: "+ cont);	
        totalTrocas += cont;	
        cont = 0;
		passou += (t_final - t_inicial);
		System.out.println("Tempo de execução: " + (t_final - t_inicial) + " ns"); 
        }
        
        
        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
        System.out.println("Total de comparações: "+ totalTrocas);
        /*
         * LAÇO PARA EXIBIR VETOR ORDENADO 
        System.out.println("*** SELECTION SORT ***");
		for (int i = 0; i < vet.length; i++) {
			System.out.printf("%3d ", vet[i]);
		}
		System.out.println();
		*/
	}
}