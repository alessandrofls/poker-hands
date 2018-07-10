package br.ufrpe.paradigmas.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Projeto{
	
	public static void main(String args[]) {
		String maosPoker[];
		try {
			
			final String CAMINHO_ARQUIVO = "C:\\Users\\Alessandro\\Desktop\\poker2K.txt";
			FileReader arq = new FileReader(CAMINHO_ARQUIVO);
		    BufferedReader lerArq = new BufferedReader(arq);
		    
		    String linha = lerArq.readLine();		    
		    
		    while (linha != null) {
		    	linha = linha.replaceAll("\\s", "");
		    	
		    	
		        System.out.println(linha);
		 
		        linha = lerArq.readLine(); // lê da segunda até a última linha
		        
		      }
		 
		      arq.close();
		}catch(IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
}
