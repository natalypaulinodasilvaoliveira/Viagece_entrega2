package modelos;

public class Compras {
	private int id;
	private int codigo_reserva;
	private String data_compra;
	private double total_compra;
	
	Viajantes vijante;
	Destinos destino;
	
	public Compras() {
	}

	public Compras(int id, int codigo_reserva, String data_compra, double total_compra) {
		this.id = id;
		this.codigo_reserva = codigo_reserva;
		this.data_compra = data_compra;
		this.total_compra = total_compra;
	}

	public Compras(int codigo_reserva, String data_compra, Double total_compra) {
		this.codigo_reserva = codigo_reserva;
		this.data_compra = data_compra;
		this.total_compra = total_compra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo_reserva() {
		return codigo_reserva;
	}

	public void setCodigo_reserva(int codigo_reserva) {
		this.codigo_reserva = codigo_reserva;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	
	public double getTotal_compra() {
		return total_compra;
	}

	public void setTotal_compra(Double total_compra) {
		this.total_compra = total_compra;
	}

	@Override
	public String toString() {
		return "Compras [id=" + id + ", codigo_reserva=" + codigo_reserva + ", data_compra=" + data_compra + " total_compra=" + total_compra +"]";
	}
	
}
