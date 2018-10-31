package com.farmacia.entidad;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tb_boleta")
public class Boleta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_bol")
	private int numBoleta;
	@ManyToOne
	@JoinColumn(name="cod_cli")
	private Cliente cliente;
	@OneToMany(mappedBy="boleta")
	private List<MedicamentoHasBoleta> MedicamentoBoleta;
	@ManyToOne
	@JoinColumn(name="cod_emp")
	private Empleado empleado;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_emi_bol")
	private Date fecEmision;
	@Column(name="monto_bol")
	private double montoBoleta;
	public Boleta(){
	}
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Date getFecEmision() {
		return fecEmision;
	}
	public void setFecEmision(Date fecEmision) {
		this.fecEmision = fecEmision;
	}
	public double getMontoBoleta() {
		return montoBoleta;
	}
	public void setMontoBoleta(double montoBoleta) {
		this.montoBoleta = montoBoleta;
	}
	
	public List<MedicamentoHasBoleta> getMedicamentoBoleta() {
		return MedicamentoBoleta;
	}
	public void setMedicamentoBoleta(List<MedicamentoHasBoleta> medicamentoBoleta) {
		MedicamentoBoleta = medicamentoBoleta;
	}
	public MedicamentoHasBoleta addMedicamentoHasBoleta(MedicamentoHasBoleta medicamentoHasBoleta) {
		getMedicamentoBoleta().add(medicamentoHasBoleta);
		medicamentoHasBoleta.setBoleta(this);

		return medicamentoHasBoleta;
	}

	public MedicamentoHasBoleta removeMedicamentoHasBoleta(MedicamentoHasBoleta medicamentoHasBoleta) {
		getMedicamentoBoleta().remove(medicamentoHasBoleta);
		medicamentoHasBoleta.setBoleta(null);

		return medicamentoHasBoleta;
	}
}
