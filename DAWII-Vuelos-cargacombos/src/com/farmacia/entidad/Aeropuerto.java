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
@Table(name="tb_aeropuerto")
public class Aeropuerto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoAeropuerto")
	private int codAeropuerto;
	
	@ManyToOne
	@JoinColumn(name="codigoPais")
	private Pais pais;
	//codCiudad
	@ManyToOne
	@JoinColumn(name="codigoCiudad")
	private Ciudad ciudad;
	
	
	@Column(name="nombreAeropuerto")
	private String nomAeropuerto;
	//referenia con vuelo aeropuerto Origen
	@OneToMany(mappedBy="aeropuerto1")
	private List<Vuelo> listaVuelo1;
	
	//referenia con vuelo aeropuerto Destino
		@OneToMany(mappedBy="aeropuerto2")
		private List<Vuelo> listaVuelo2;
	
	/*
	@OneToMany(mappedBy="aeropuerto")
	private List<Vuelo> listaVuelo;
	
*/
	

	public Pais getPais() {
		return pais;
	}


	public int getCodAeropuerto() {
		return codAeropuerto;
	}


	public void setCodAeropuerto(int codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}


	public String getNomAeropuerto() {
		return nomAeropuerto;
	}


	public void setNomAeropuerto(String nomAeropuerto) {
		this.nomAeropuerto = nomAeropuerto;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	public List<Vuelo> getListaVuelo1() {
		return listaVuelo1;
	}


	public void setListaVuelo1(List<Vuelo> listaVuelo1) {
		this.listaVuelo1 = listaVuelo1;
	}


	public List<Vuelo> getListaVuelo2() {
		return listaVuelo2;
	}


	public void setListaVuelo2(List<Vuelo> listaVuelo2) {
		this.listaVuelo2 = listaVuelo2;
	}

	
	
	
	
	
	/*@OneToMany(mappedBy="modelo")
	private List<Medicamento> listaMedicamento;*/
	
	
	
	
}
