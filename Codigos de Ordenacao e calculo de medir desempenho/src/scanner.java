import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scanner {
	private final static int NUM_REP = 5;

	public static int[] lerVetor() {
		int[] vet = null;
		try {
		        File arquivo = new File("C:/Users/Wellington/Casos de Teste/entrada1.txt");//caminho
        		Scanner leitor = new Scanner(arquivo);
        
			int tamanho = Integer.parseInt(leitor.nextLine());
			vet = new int[tamanho];
			

		        for (int i = 0; i < tamanho; i++) {
				vet[i] = Integer.parseInt(leitor.nextLine());
				
			}
		        

		        leitor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Deu ruim");
			System.exit(1);
		}

		return vet;
		
	}
}
