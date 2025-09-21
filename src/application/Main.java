package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reserva;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Reserva> reservas = new ArrayList<>();
		
		System.out.print("Número do quarto: ");
		Integer quarto = sc.nextInt();
		
		System.out.print("Data de entrada (DD/MM/YYYY): ");
		LocalDate dataEntrada = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.print("Data de saída (DD/MM/YYYY): ");
		LocalDate dataSaida = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		if (dataSaida.isBefore(dataEntrada) == true) {
			System.out.println("Erro na reserva: A data de saída deve ser após a data de entrada.");
		} else {
			Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida);
			reservas.add(reserva);
			
			System.out.println("Reserva: " + reserva);
			
			System.out.println("Entre com as datas para atualizar a reserva: ");
			System.out.print("Nova data de entrada (DD/MM/YYYY): ");
			LocalDate dataEntradaAtualizada = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Nova data de saída (DD/MM/YYYY): ");
			LocalDate dataSaidaAtualizada = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			if (dataEntradaAtualizada.isBefore(dataEntrada) || dataSaidaAtualizada.isBefore(dataSaida)) {
				System.out.println("Erro: As datas atualizadas devem ser após as datas originais.");
			} else if (dataSaidaAtualizada.isBefore(dataEntradaAtualizada)) {
				System.out.println("Erro: A data de saída deve ser após a data de entrada.");
			} else {
				reserva.atualizarDatas(dataEntradaAtualizada, dataSaidaAtualizada);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		sc.close();
	}
}
