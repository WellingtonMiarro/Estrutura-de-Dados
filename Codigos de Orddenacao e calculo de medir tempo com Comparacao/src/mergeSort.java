public class mergeSort {
	private static int[] vetor;
	private static int cont = 0;
	private static int aux = 0;
	
   
	public static void sort(int inicio, int fim) {
		cont++;
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
		cont++;
		while (i <= meio && j <= fim) {
			cont++;
			if (vetorB[i] <= vetorB[j]) {
				vetor[k] = vetorB[i];
				i = i + 1;
				
			} else {
				vetor[k] = vetorB[j];
				j = j + 1;
				
			}
			k++;
			aux++;
		}
		
		if(aux > 0) {
			aux++;
			cont+=aux;
			aux = 0;
		}
		
		
		cont++;
		while (i <= meio) {
            vetor[k] = vetorB[i];
            k++;
            i++;
        }
		aux++;
	}
	public static void main(String[] args) {

		vetor = scanner.lerVetor();
		final int NUM_REP = 5;
		
		int totalCompara = 0;
		long passou = 0;
        for(int i = 1; i <= NUM_REP; ++i) {
        	long t_inicial = System.nanoTime(); 
        	mergeSort.sort(0, vetor.length - 1);
        	long t_final = System.nanoTime();
        	
        	if(aux > 0) {
        		aux++;
        		cont+=aux;
        		aux = 0;
        	}
        	totalCompara += cont;
        	System.out.println("Total de comparações na "+ i +"° ordenação = "+cont);
        	cont = 0;
        	passou += (t_final - t_inicial);
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
        System.out.println("Total de comparações: "+ totalCompara);

        /*
		System.out.println("*** MERGE SORT ***");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%3d ", vetor[i]);
		}
		System.out.println();
		*/
	}
}