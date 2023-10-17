package model;

import java.time.LocalDate;

public class Reserva {

	private int numeroReserva;
	private LocalDate dataReserva;
	private double valorReserva;
	private String formaPagamento;
	private Cliente cliente;
	private Destino destino;

	public Reserva() {

	}

	public Reserva(int numeroReserva, LocalDate dataReserva, double valorReserva, String formaPagamento) {
		this.numeroReserva = numeroReserva;
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
	}

	public Reserva(LocalDate dataReserva, double valorReserva, String formaPagamento, Cliente cliente,
			Destino destino) {
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.destino = destino;
	}

	public Reserva(int numeroReserva, LocalDate dataReserva, double valorReserva, String formaPagamento,
			Cliente cliente, Destino destino) {
		this.numeroReserva = numeroReserva;
		this.dataReserva = dataReserva;
		this.valorReserva = valorReserva;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.destino = destino;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	public double getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(double valorReserva) {
		this.valorReserva = valorReserva;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Reserva [numeroReserva=" + numeroReserva + ", dataReserva=" + dataReserva + ", valorReserva="
				+ valorReserva + ", formaPagamento=" + formaPagamento + ", cliente=" + cliente.getCpf() + ", destino="
				+ destino.getId() + "]";
	}

}
