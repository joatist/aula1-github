package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoPorHora;
import entidade.Departamento;
import entidade.Trabalhador;
import entidade.enums.NivelDeTrabalho;

public class ProgramaTrabalhador {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String NomeDepartamento = sc.nextLine();
		System.out.println("Insira os dados do trabalhador: "); 
		System.out.print("Nome: ");
		String NomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salario Base: ");
		
		double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(NomeTrabalhador, NivelDeTrabalho.valueOf(nivelTrabalhador), salarioBase, new Departamento(NomeDepartamento));
		
		System.out.print("Quantos contratos para este trabalhador? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Insira os dados do contrato nº  " + i);
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora( dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);		
		} 
		
		System.out.println();
		System.out.print("Insira o mês e o ano para calcular a renda (MM/AAAA): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println();
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda do projeto em " + mesEAno + ":  " +  String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		sc.close();

	}

}
