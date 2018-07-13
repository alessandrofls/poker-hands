package br.ufrpe.paradigmas.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Projeto{

	public static void main(String args[]) {
		try {

			final String CAMINHO_ARQUIVO = "C:\\Users\\Alessandro\\Desktop\\poker2K.txt";
			FileReader arq = new FileReader(CAMINHO_ARQUIVO);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();		    

			int quatroIguais = 0;
			int diferentes = 0;

			while (linha != null) {
				linha = linha.replaceAll("\\s", "");
				int igual = 0;
				int diferente = 0;
				for(int i = 0; i < linha.length(); i++) {
					int j = 0;
					//percorre a linha verificando o caracter no indice i com o restante da linha;
					do {  			
						if(linha.charAt(i) == linha.charAt(j)) {
							igual++;
						}else if(linha.charAt(i) != linha.charAt(j)) {
							diferente++;
						}
						j++;
					}while(j < linha.length());
					
					if(igual == 4) {
						quatroIguais++;
					}else if(diferente == 5) {
						diferentes++;
				}

				
				}

				linha = lerArq.readLine(); // lê da segunda até a última linha

			}
			System.out.println(quatroIguais +"  "+ diferentes);

			arq.close();
		}catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

}
