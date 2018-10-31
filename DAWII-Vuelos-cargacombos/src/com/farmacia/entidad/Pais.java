package com.farmacia.entidad;
import javax.crypto.CipherInputStream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pais")
public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoPais")
	private int codPais;
	@Column(name="nombrePais")
	private String nomPais;
	
	@OneToMany(mappedBy="pais")
	private List<Ciudad> listaCiudad;
	
	@OneToMany(mappedBy="pais")
	private List<Aeropuerto> listaAeropuerto;
	
	//la referencias en vuelo paisOrigen
	@OneToMany(mappedBy="pais1")
	private List<Vuelo> listaVuelo1;
	
	//la referencias en vuelo paisDestino
	@OneToMany(mappedBy="pais2")
	private List<Vuelo> listaVuelo2;
	
	/*@OneToMany(mappedBy="pais")
	private List<Vuelo> listaVuelo;
	*/
	
	/*
	@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamentos;
	
	@OneToMany(mappedBy="laboratorio")
	private List<TipoMedicamento> listaTipoMedicamento;
	
	@OneToMany(mappedBy="laboratorio")
	private List<Modelo> listaModelo;
	
	*/
	
	public Pais(){
		
	}
	
	

	


	public int getCodPais() {
		return codPais;
	}


	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}


	public String getNomPais() {
		return nomPais;
	}


	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}


	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}


	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
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
	
	
	
}

