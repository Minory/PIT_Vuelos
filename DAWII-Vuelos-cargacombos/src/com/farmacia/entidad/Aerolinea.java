package com.farmacia.entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_aerolinea")
public class Aerolinea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoAerolinea")
	private int codAerolinea;
	@Column(name="rucAerolinea")
	private String rucAerolinea;
	@Column(name="nombreAerolinea")
	private String nomAerolinea;
	
	@OneToMany(mappedBy="aerolinea")
	private List<Tipo_Avion> listaTipo_Avion;
	
	//aerolinea con vuelo
	@OneToMany(mappedBy="aerolinea")
	private List<Vuelo> listaVuelo;
	
	/*
	@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamentos;
	
	@OneToMany(mappedBy="laboratorio")
	private List<TipoMedicamento> listaTipoMedicamento;
	
	@OneToMany(mappedBy="laboratorio")
	private List<Modelo> listaModelo;
	
	*/
	
	public Aerolinea(){
		
	}


	public int getCodAerolinea() {
		return codAerolinea;
	}


	public void setCodAerolinea(int codAerolinea) {
		this.codAerolinea = codAerolinea;
	}


	public String getRucAerolinea() {
		return rucAerolinea;
	}


	public void setRucAerolinea(String rucAerolinea) {
		this.rucAerolinea = rucAerolinea;
	}


	public String getNomAerolinea() {
		return nomAerolinea;
	}


	public void setNomAerolinea(String nomAerolinea) {
		this.nomAerolinea = nomAerolinea;
	}


	public List<Tipo_Avion> getListaTipo_Avion() {
		return listaTipo_Avion;
	}


	public void setListaTipo_Avion(List<Tipo_Avion> listaTipo_Avion) {
		this.listaTipo_Avion = listaTipo_Avion;
	}


	public List<Vuelo> getListaVuelo() {
		return listaVuelo;
	}


	public void setListaVuelo(List<Vuelo> listaVuelo) {
		this.listaVuelo = listaVuelo;
	}
	
	
	
}

