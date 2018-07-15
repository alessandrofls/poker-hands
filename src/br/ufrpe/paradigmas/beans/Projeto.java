package br.ufrpe.paradigmas.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Projeto{

	public static void main(String args[]) {
		try {

			FileReader arq = new FileReader("C:\\Users\\Alessandro\\Desktop\\poker2M.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha;
			int totalQuatroIguais= 0;
			int totalDiferente = 0;
			int totalSequencia = 0;

			while ((linha = lerArq.readLine()) != null) {
				linha = linha.replaceAll("\\s", "");

				totalQuatroIguais += iguais(linha);
				totalSequencia += sequencia(linha);
				totalDiferente += sequencia(linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}
			System.out.println(totalQuatroIguais + " " + totalSequencia + " " + totalDiferente );

			arq.close();
		}catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

	}
	public static int iguais(String teste) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < teste.length(); i++) {
			for(int j = i+1; j < teste.length(); j++) {
				if(teste.charAt(i) == teste.charAt(j)) {
					count += 1;
				}
			}
		}
		if (count == 4) {
			result = 1;
		}

		return result;
	}


	public static int diferentes(String teste) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < teste.length(); i++) {
			for(int j = i+1; j < teste.length(); j++) {
				if(teste.charAt(i) != teste.charAt(j)) {
					count += 1;
				}
			}
		}
		if (count == 4) {
			result = 1;
		}

		return result;
	}

	public static int sequencia(String teste) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < teste.length(); i++) {
			for(int j = i+1; j < teste.length(); j++) {
				if(teste.charAt(i) < teste.charAt(j)) {
					count += 1;
				}
			}
		}
			if(count == 5) {
				result = 1;
			}

			return result;
		}
	}

