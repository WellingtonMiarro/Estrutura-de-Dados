
public class mergeSort {
	private static int[] vetor;

	public static void sort(int inicio, int fim) {

		if (inicio < fim) {
			int meio = inicio + (fim - inicio) / 2;
				
			sort(inicio, meio);
			sort(meio + 1, fim);
			intercala(inicio, meio, fim);
		}
	}
	public static void intercala(int inicio, int meio, int fim) {
		int i, j, k;
		int[] vetorB = new int[vetor.length];

		for (i = inicio; i <= fim; i++) {
			vetorB[i] = vetor[i];
		}

		i = inicio;
		j = meio + 1;
		k = inicio;
		while (i <= meio && j <= fim) {
			if (vetorB[i] <= vetorB[j]) {
				vetor[k] = vetorB[i];
				i = i + 1;
				
			} else {
				vetor[k] = vetorB[j];
				j = j + 1;
				
			}
			k++;
		}
		
		while (i <= meio) {
            vetor[k] = vetorB[i];
            k++;
            i++;
        }
	}
	
	public static void main(String[] args) {

		vetor = scanner.lerVetor();
		final int NUM_REP = 5;
		System.out.println("tamanho: "+ vetor);
		

		long passou = 0;
        for(int i = 0; i < NUM_REP; ++i) {
        	
        	long t_inicial = System.nanoTime(); 
        	mergeSort.sort(0, vetor.length - 1);
        	
        	long t_final = System.nanoTime();

		passou += (t_final - t_inicial);
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
        
        /*
		System.out.println("*** MERGE SORT ***");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%3d ", vetor[i]);
		}
		System.out.println();
		*/
	}
}
