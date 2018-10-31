package com.farmacia.entidad;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_medicamento_has_boleta")
public class MedicamentoHasBoleta {
	@EmbeddedId
	private MedicamentoHasBoletaPK id;
	@Column(name="can")
	private int cantidad;
	@Column(name="pre")
	private double precio;
	@ManyToOne
	@JoinColumn(name="num_bol",referencedColumnName="num_bol",insertable=false,	updatable=false)
	private Boleta boleta;
	@ManyToOne
	@JoinColumn(name="cod_med",referencedColumnName="cod_med", insertable=false,	updatable=false)
	private Medicamento medicamento;
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public MedicamentoHasBoletaPK getId() {
		return id;
	}
	public void setId(MedicamentoHasBoletaPK id) {
		this.id = id;
	}	
	
}
