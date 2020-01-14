public class quickSort {
	private static int[] vetor;
	private static int cont = 0;
	private static int aux = 0;
	private static int auxSuper = 0;

	
	public static void sort(int inicio, int fim) {
		int esq = inicio;
		int dir = fim;
		int pivo = vetor[(esq + dir) / 2];
		int troca;
		
		cont++;
		while (esq <= dir) {
			cont++;
			while (vetor[esq] < pivo) {
				esq = esq + 1;
				aux++;
			}
			//IF de comparações do laço
			if(aux > 0) {
				aux++;
				cont += aux;
				aux=0;
			}
			//IF de comparações do laço
			cont++;
			while (vetor[dir] > pivo) {
				dir = dir - 1;
				aux++;
			}
			//IF de comparações do laço
			if(aux > 0) {
				aux++;
				cont += aux;
				aux = 0;
			}
			//IF de comparações do laço
			
			cont++;
			if (esq <= dir) {
				
				troca = vetor[esq];
				vetor[esq] = vetor[dir];
				vetor[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;

			}
	
			auxSuper++;
		}
		if(auxSuper > 0) {
			auxSuper++;
			cont += auxSuper;
			auxSuper = 0;
		}
		
		cont++;
		if (dir > inicio) {
			sort(inicio, dir);
		}
		cont++;
		if (esq < fim) {
			sort(esq, fim);
		}
	}

	public static void main(String[] args) {
		
		vetor = scanner.lerVetor();
		final int NUM_REP = 5;
		
		int totalCompara = 0;
		long passou = 0;
        for(int i = 1; i <= NUM_REP; ++i) {
        	long t_inicial = System.nanoTime(); 
        	sort(0, vetor.length - 1);
        	long t_final = System.nanoTime();
        
        System.out.println("Total de comparações na "+ i +"° ordenação = "+cont);
        System.out.println("Tamanho do vetor = "+vetor.length);
             
        aux = 0;
       
        totalCompara += cont;		
        cont = 0;
        passou += (t_final - t_inicial);
        }
        

        passou = passou / NUM_REP;
        System.out.print("Total: "+passou+" nanosegundos (ns) \n");
        System.out.println("Total de comparações: "+ totalCompara);
        
		/*
		System.out.println("*** QUICK SORT ***");
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%3d ", vetor[i]);
		}
		System.out.println();
		*/
	}
}