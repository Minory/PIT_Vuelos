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
@Table(name="tb_tipo_avion")
public class Tipo_Avion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoTipo_avion")
	private int codTipoAvion;
	@Column(name="nombreTipo_avion")
	private String nomTipoAvion;
	@Column(name="capacidad")
	private int capacidad;
	@Column(name="fabricanteTipo_Avion")
	private String facTipoAvion;
	@ManyToOne
	@JoinColumn(name="codigoAerolinea")
	private Aerolinea aerolinea;
	
	@OneToMany(mappedBy="tipoAvion")
	private List<Vuelo> listaVuelo;
	
	
	
	public int getCodTipoAvion() {
		return codTipoAvion;
	}
	public void setCodTipoAvion(int codTipoAvion) {
		this.codTipoAvion = codTipoAvion;
	}
	public String getNomTipoAvion() {
		return nomTipoAvion;
	}
	public void setNomTipoAvion(String nomTipoAvion) {
		this.nomTipoAvion = nomTipoAvion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getFacTipoAvion() {
		return facTipoAvion;
	}
	public void setFacTipoAvion(String facTipoAvion) {
		this.facTipoAvion = facTipoAvion;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public List<Vuelo> getListaVuelo() {
		return listaVuelo;
	}
	public void setListaVuelo(List<Vuelo> listaVuelo) {
		this.listaVuelo = listaVuelo;
	}
	
	
	/*
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Medicamento> listaMedicamento;
	
	@OneToMany(mappedBy="tipoMedicamento")
	private List<Modelo> listaModelo;
	
	
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	*/
	
	
}
