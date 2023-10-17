package modelos;

public class Destinos {
	private int id;
	private String data_entrada;
	private String data_saida;
	private double valor_compra;
	
	
	public Destinos() {
	}

	public Destinos(int id, String data_entrada, String data_saida, double valor_compra) {
		this.id = id;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.valor_compra = valor_compra;
	}

	public Destinos(String data_entrada, String data_saida, double valor_compra) {
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
		this.valor_compra = valor_compra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}

	public String getData_saida() {
		return data_saida;
	}

	public void setData_saida(String data_saida) {
		this.data_saida = data_saida;
	}

	public double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	@Override
	public String toString() {
		return "Destinos [id=" + id + ", data_entrada=" + data_entrada + ", data_saida=" + data_saida
				+ ", valor_compra=" + valor_compra + "]";
	}
	
}
