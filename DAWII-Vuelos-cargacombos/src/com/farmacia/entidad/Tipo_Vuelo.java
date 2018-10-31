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
@Table(name="tb_tipo_vuelo")
public class Tipo_Vuelo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoTipo_vuelo")
	private int codTipoVuelo;
	@Column(name="nombreTipo_vuelo")
	private String nomTipoVuelo;
	
	@OneToMany(mappedBy="tipoVuelo")
	private List<Vuelo> listaVuelo;
	
	/*@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamentos;
	*/
		
	public Tipo_Vuelo(){
		
	}

	public int getCodTipoVuelo() {
		return codTipoVuelo;
	}

	public void setCodTipoVuelo(int codTipoVuelo) {
		this.codTipoVuelo = codTipoVuelo;
	}

	public String getNomTipoVuelo() {
		return nomTipoVuelo;
	}

	public void setNomTipoVuelo(String nomTipoVuelo) {
		this.nomTipoVuelo = nomTipoVuelo;
	}

	public List<Vuelo> getListaVuelo() {
		return listaVuelo;
	}

	public void setListaVuelo(List<Vuelo> listaVuelo) {
		this.listaVuelo = listaVuelo;
	}
	
	
	
}

