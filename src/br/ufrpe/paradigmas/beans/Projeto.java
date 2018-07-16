package br.ufrpe.paradigmas.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Projeto{

	public static void main(String args[]) {
		principal("C:\\Users\\Alessandro\\eclipse-workspace\\poker-hands\\bin\\br\\ufrpe\\paradigmas\\beans\\poker2K.txt");
		principal("C:\\Users\\Alessandro\\Desktop\\poker2M.txt");
		principal("C:\\Users\\Alessandro\\Desktop\\poker200M.txt");

		
	}

	public static void principal(String path) {
		long tempoInicio = System.currentTimeMillis();
		String linha;
		int totalQuatroIguais= 0;
		int totalDiferente = 0;
		int totalSequencia = 0;

		try {

			FileReader arq = new FileReader(path);
			BufferedReader lerArq = new BufferedReader(arq);

			while ((linha = lerArq.readLine()) != null) {
				linha = linha.replaceAll("\\s", "");

				totalQuatroIguais += iguais(linha);
				totalSequencia += sequencia(linha);
				totalDiferente += sequencia(linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}
			arq.close();
		}catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		long tempo = System.currentTimeMillis()-tempoInicio;
		
		escreverNoArquivo(tempo, totalQuatroIguais, totalDiferente, totalSequencia);

	}

	public static int iguais(String teste) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < teste.length(); i++) {
			for(int j = i+1; j < teste.length(); j++) {
				if(teste.codePointAt(i) == teste.codePointAt(j)) {
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
				if((teste.codePointAt(i) != teste.codePointAt(j)) && !((teste.codePointAt(i) < teste.codePointAt(j)))) {
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
				if(teste.codePointAt(i) < teste.codePointAt(j)) {
					count += 1;
				}
			}
		}
		if(count == 4) {
			result = 1;
		}

		return result;
	}

	public static void escreverNoArquivo(long tempo, int quatroIguais, int todasDiferentes, int sequencias) {
		try {

			// Conteudo
			String content = tempo + " " + quatroIguais + " " + todasDiferentes + " " + sequencias;

			// Cria arquivo
			File file = new File("teste.txt");

			// Se o arquivo nao existir, ele gera
			if (!file.exists()) {
				file.createNewFile();
			}

			// Prepara para escrever no arquivo
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter saida = new PrintWriter(bw);

			// Escreve e fecha arquivo
			saida.println(content);
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

