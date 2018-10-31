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
@Table(name="tb_ciudad")
public class Ciudad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoCiudad")
	private int codCiudad;
	@Column(name="nombreCiudad")
	private String nomCiudad;
	//muchos a uno de ciudad a Pais
	@ManyToOne
	@JoinColumn(name="codigoPais")
	private Pais pais;
	
	@OneToMany(mappedBy="ciudad")
	private List<Aeropuerto> listaAeropuerto;
	
	@OneToMany(mappedBy="ciudad1")
	private List<Vuelo> listaVuelo1;
	
	@OneToMany(mappedBy="ciudad2")
	private List<Vuelo> listaVuelo2;
	
	/*
	@OneToMany(mappedBy="ciudad")
	private List<Vuelo> listaVuelo;
*/
	public int getCodCiudad() {
		return codCiudad;
	}

	public void setCodCiudad(int codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Aeropuerto> getListaAeropuerto() {
		return listaAeropuerto;
	}

	public void setListaAeropuerto(List<Aeropuerto> listaAeropuerto) {
		this.listaAeropuerto = listaAeropuerto;
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
