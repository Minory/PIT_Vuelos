package com.farmacia.entidad;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_modelo")
public class Modelo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_modelo")
	private int codModelo;
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private TipoMedicamento tipoMedicamento;
	@Column(name="nom_modelo")
	private String nomModelo;
	
	@OneToMany(mappedBy="modelo")
	private List<Medicamento> listaMedicamento;
	
	
	public int getCodModelo() {
		return codModelo;
	}
	public void setCodModelo(int codModelo) {
		this.codModelo = codModelo;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	public String getNomModelo() {
		return nomModelo;
	}
	public void setNomModelo(String nomModelo) {
		this.nomModelo = nomModelo;
	}
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	
	
	
	
}
