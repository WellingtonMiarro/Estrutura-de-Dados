
public class quickSort {
	private static int[] vetor;

	public static void sort(int inicio, int fim) {
		int esq = inicio;
		int dir = fim;
		int pivo = vetor[(esq + dir) / 2];
		int troca;

		while (esq <= dir) {
			while (vetor[esq] < pivo) {
				esq = esq + 1;
			}
			
			while (vetor[dir] > pivo) {
				dir = dir - 1;
			}
			
			if (esq <= dir) {
				troca = vetor[esq];
				vetor[esq] = vetor[dir];
				vetor[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}

		if (dir > inicio) {
			sort(inicio, dir);
		}

		if (esq < fim) {
			sort(esq, fim);
		}
	}

	public static void main(String[] args) {
		vetor = scanner.lerVetor();
		final int NUM_REP = 5;
		
		long passou = 0;
        for(int i = 0; i < NUM_REP; ++i) {
        	long t_inicial = System.nanoTime(); 
        	sort(0, vetor.length - 1);
        	long t_final = System.nanoTime();

		passou += (t_final - t_inicial);
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");

		/*
		System.out.println("*** QUICK SORT ***");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%3d ", vetor[i]);
		}
		System.out.println();
		*/
	}
}
