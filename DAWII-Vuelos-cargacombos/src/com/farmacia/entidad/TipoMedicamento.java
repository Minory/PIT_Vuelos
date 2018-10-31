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
@Table(name="tb_tipo_medicamento")
public class TipoMedicamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tip_med")
	private int codTipoMedicamento;
	@Column(name="nom_tip_med")
	private String nomTipoMedicamento;
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Medicamento> listaMedicamento;
	
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Modelo> listaModelo;
	
	
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	public int getCodTipoMedicamento() {
		return codTipoMedicamento;
	}
	public void setCodTipoMedicamento(int codTipoMedicamento) {
		this.codTipoMedicamento = codTipoMedicamento;
	}
	public String getNomTipoMedicamento() {
		return nomTipoMedicamento;
	}
	public void setNomTipoMedicamento(String nomTipoMedicamento) {
		this.nomTipoMedicamento = nomTipoMedicamento;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	public List<Modelo> getListaModelo() {
		return listaModelo;
	}
	public void setListaModelo(List<Modelo> listaModelo) {
		this.listaModelo = listaModelo;
	}
	
}
