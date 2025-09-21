package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reserva {
	private Integer quarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	public Reserva() {}
	
	public Reserva(Integer quarto, LocalDate dataEntrada, LocalDate dataSaida) {
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	public Integer getQuarto() {
		return quarto;
	}
	
	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Integer getDuracao() {
		Period duracao = Period.between(dataEntrada, dataSaida);
		return duracao.getDays();
	}
	
	public void atualizarDatas(LocalDate dataEntrada, LocalDate dataSaida) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}
	
	@Override
	public String toString() {
		return "Quarto: " + quarto + ", data de entrada: " + dataEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", data de saída: " + dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " + getDuracao() + " noites";
	}
}