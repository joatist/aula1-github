package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entidade.Comentario;
import entidade.Postagem;

public class ProgramaPostagem {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comentario c1 = new Comentario("Boa viagem!");
		Comentario c2 = new Comentario("Uau, isso � demais!");
		Postagem p1 = new Postagem(
				sdf.parse("21/06/2018 13:05:44"),
				"Viajar para a Nova Zel�ndia",
				"Vou visitar este pa�s maravilhoso!",
				12);
		
		p1.adicionarComentario(c1);
		p1.adicionarComentario(c2);
		
		Comentario c3 = new Comentario("Boa noite");
		Comentario c4 = new Comentario("Que a For�a esteja com voc�");
		Postagem p2 = new Postagem(
				sdf.parse("21/06/2018 13:05:44"),
				"Boa noite pessoal",
				"At� amanh� ",
				5);
		
		p2.adicionarComentario(c3);
		p2.adicionarComentario(c4);
		
		System.out.println(p1);
		System.out.println(p2);
	}

}
	
