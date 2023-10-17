package model;

public class Destino {
	
	private int idDestino;
	private String nomeDestino;
	private double precoDestino;
	
	public Destino() {
		
	}

	public Destino(String nomeDestino, double precoDestino) {
		this.nomeDestino = nomeDestino;
		this.precoDestino = precoDestino;
	}

	public Destino(int id, String nomeDestino, double precoDestino) {
		this.idDestino = id;
		this.nomeDestino = nomeDestino;
		this.precoDestino = precoDestino;
	}

	public int getId() {
		return idDestino;
	}

	public void setId(int id) {
		this.idDestino = id;
	}

	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public double getPrecoDestino() {
		return precoDestino;
	}

	public void setPrecoDestino(double precoDestino) {
		this.precoDestino = precoDestino;
	}

	@Override
	public String toString() {
		return "Destino [id=" + idDestino + ", nomeDestino=" + nomeDestino + ", precoDestino=" + precoDestino + "]";
	}
	
	
	
}
