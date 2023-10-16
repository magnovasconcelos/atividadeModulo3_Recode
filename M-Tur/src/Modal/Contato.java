package Modal;

public class Contato {

	private String assunto;
	private String mensagem;
	private Cliente cliente;
	
	public Contato() {
		
	}
	public Contato(String assunto, String mensagem, Cliente cliente) {
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.cliente = cliente;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Contato [assunto=" + assunto + ", mensagem=" + mensagem + ", cliente=" + cliente.getCpf() + "]";
	}
	
	
	
	
}
