package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO JOGO... QUE VENÇA O MELHOR!");
		System.out.println();
		
		//Tabuleiro tabuleiro = new Tabuleiro(8, 8);
		
		Scanner sc = new Scanner(System.in);		
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while (true) {
			try {
				UI.limpaTela();
				UI.imprimeTabuleiro(partidaXadrez.getPecas());
				
				System.out.println();
				System.out.print("ORIGEM : ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				System.out.println();
				System.out.print("DESTINO : ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
	
				PecaXadrez pecaCapturada = partidaXadrez.executarMovimentoXadrez(origem, destino); 
			}
			catch (XadrezException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e){
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}		
	}
}
