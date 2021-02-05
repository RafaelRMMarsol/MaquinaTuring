package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Maquina {
	
	int cont;
	char fita [];
	
	public static void main (String args[]) {
		Maquina maq = new Maquina();
                String palavra = maq.lerArquivo(maq.procurarArquivo());
		maq.iniciar(palavra);
	}
	
	public void iniciar (String sentenca) {
		cont = 0;
		fita = sentenca.toCharArray();
		q0();
	}
		public void q0() {
			if (cont < fita.length) {
				if(fita[cont] == 'T') {
				fita[cont] = 'T';
				cont++;
				q4();
			}			
				else if(fita[cont] == 'B') {
				fita[cont] = 'B';
				cont++;
				q3();
			}
				else if(fita[cont] == 'a') {
				fita[cont] = 'A';
				cont++;
				q1();
			}
				else 
			{
				qerro();
			}
			
			
		}
	}
		public void q1() {
			if (cont < fita.length) {
				if(fita[cont] == 'a') {
				fita[cont] = 'a';
				cont++;
				q1();
			}			
				else if(fita[cont] == 'B') {
				fita[cont] = 'B';
				cont++;
				q1();
			}
				else if(fita[cont] == 'b') {
				fita[cont] = 'B';
				cont--;
				q2();
			}
				else 
			{
				qerro();
			}
			
			
		}
		}
		public void q2() {
			if (cont < fita.length) {
				if(fita[cont] == 'a') {
				fita[cont] = 'a';
				cont--;
				q2();
			}			
				else if(fita[cont] == 'B') {
				fita[cont] = 'B';
				cont--;
				q2();
			}
				else if(fita[cont] == 'A') {
				fita[cont] = 'A';
				cont++;
				q0();
			}
				else 
			{
				qerro();
			}
			
			
		}
		}
		public void q3() {
			if (cont < fita.length) {
				if(fita[cont] == 'B') {
				fita[cont] = 'B';
				cont++;
				q3();
			}			
				else if(fita[cont] == 'T') {
				fita[cont] = 'T';
				cont++;
				q4();
			}
				else 
			{
				qerro();
			}
			
			
		}
		}
		public void q4() {
			String palavra = "";
			for (int i = 0; i < fita.length; i++) {
				palavra = palavra + fita[i];
			}
			System.err.println("Palavra aceita: " + palavra);
		}
		public void qerro() {
			String palavra = "";
			for (int i = 0; i < fita.length; i++) {
				palavra = palavra + fita[i];
			}
			System.err.println("Palavra nao aceita " + palavra);
		}
                
        public File procurarArquivo(){
            Scanner scan = new Scanner(System.in);
            String nomeAr;
            System.out.println("Entre com o nome desejado procura");
            nomeAr = scan.nextLine();
            File arquivo = new 
            File("C:/Users/rafam/OneDrive/Área de Trabalho/arquivosProg/"+nomeAr+".txt");
            try{
                if(!arquivo.exists()){
                    criaArquivo();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            return arquivo;
        }
        
        public void criaArquivo(){
            Scanner scan = new Scanner(System.in);
            String nomeAr;
            System.out.println("Entre com o nome desejado cria");
            nomeAr = scan.nextLine();
            try{
            File arquivo =  new 
            File("C:/Users/rafam/OneDrive/Área de Trabalho/arquivosProg/"+nomeAr+".txt");
            arquivo.createNewFile();
            }catch(IOException e ){
                e.printStackTrace();
            }
            
        }
        
        public String lerArquivo(File file){
            String linha = "";
            try{
            FileReader nfile = new FileReader(procurarArquivo());
            BufferedReader br = new BufferedReader(nfile);
            while(br.ready()){
                linha = br.readLine();
            }
            br.close();
            nfile.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
            return linha;
        }
        
        public void escreveArquivo(File file){
            try{
                FileWriter wfile = new FileWriter(file, true);
                BufferedWriter brW = new BufferedWriter(wfile);
                Scanner scan = new Scanner(System.in);
                String nomeAr;
                System.out.println("Entre com o que sera escrito");
                nomeAr = scan.nextLine();
                brW.write(nomeAr);
                brW.newLine();
                brW.close();
                wfile.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		
	

}
