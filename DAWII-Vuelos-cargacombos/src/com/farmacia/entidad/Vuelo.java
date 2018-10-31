package com.farmacia.entidad;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.servlet.ServletContext;
@Entity
@Table(name="tb_vuelo")
public class Vuelo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigoVuelo")
	private int codVuelo;
	//pais origen
	@ManyToOne
	@JoinColumn(name="codigoPaisOrigen")
	private Pais pais1;
	//ciudad origen
	@ManyToOne
	@JoinColumn(name="codigoCiudadOrigen")
	private Ciudad ciudad1;
	//aeropuerto Origen
	@ManyToOne
	@JoinColumn(name="codigoAeropuertoOrigen")
	private Aeropuerto aeropuerto1;
	//pais destino
	@ManyToOne
	@JoinColumn(name="codigoPaisDestino")
	private Pais pais2;
	//Ciudad destino
	@ManyToOne
	@JoinColumn(name="codigoCiudadDestino")
	private Ciudad ciudad2;
	//aeropuerto destino
	@ManyToOne
	@JoinColumn(name="codigoAeropuertoDestino")
	private Aeropuerto aeropuerto2;
	//aerolinea
	
		@ManyToOne
		@JoinColumn(name="codigoAerolinea")
		private Aerolinea aerolinea;
	//tipo avion
		@ManyToOne
		@JoinColumn(name="codigoTipo_avion")
		private Tipo_Avion tipoAvion;
	//capacidad de avion
	@Column(name="capacidad")
	private int capacidad;
	//tarifa
	@Column(name="tarifaVuelo")
	private double tarifa;
	//fecha partida vuelo
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPartidaVuelo")
	private Date fecPartida;
	//hora de partida
	@Column(name="horaPartidaVuelo")
	private String horaPartida;
	//fecha llegada
	@Temporal(TemporalType.DATE)
	@Column(name="fechaDestinoVuelo")
	private Date fecDestino;
	//hora de Destino
	@Column(name="horaDestinoVuelo")
	private String horaDestino;
	//tipo vuelo
	@ManyToOne
	@JoinColumn(name="codigoTipo_vuelo")
	private Tipo_Vuelo tipoVuelo;
	
	
	
	public Vuelo(){
		pais1=new Pais();
		ciudad1=new Ciudad();
		aeropuerto1=new Aeropuerto();
		pais2=new Pais();
		ciudad2=new Ciudad();
		aeropuerto2=new Aeropuerto();
		aerolinea=new Aerolinea();
		tipoAvion=new Tipo_Avion();
		tipoVuelo=new Tipo_Vuelo();
	}

	public int getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(int codVuelo) {
		this.codVuelo = codVuelo;
	}

	public Pais getPais1() {
		return pais1;
	}

	public void setPais1(Pais pais1) {
		this.pais1 = pais1;
	}

	public Ciudad getCiudad1() {
		return ciudad1;
	}

	public void setCiudad1(Ciudad ciudad1) {
		this.ciudad1 = ciudad1;
	}

	public Aeropuerto getAeropuerto1() {
		return aeropuerto1;
	}

	public void setAeropuerto1(Aeropuerto aeropuerto1) {
		this.aeropuerto1 = aeropuerto1;
	}

	public Pais getPais2() {
		return pais2;
	}

	public void setPais2(Pais pais2) {
		this.pais2 = pais2;
	}

	public Ciudad getCiudad2() {
		return ciudad2;
	}

	public void setCiudad2(Ciudad ciudad2) {
		this.ciudad2 = ciudad2;
	}

	public Aeropuerto getAeropuerto2() {
		return aeropuerto2;
	}

	public void setAeropuerto2(Aeropuerto aeropuerto2) {
		this.aeropuerto2 = aeropuerto2;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Tipo_Avion getTipoAvion() {
		return tipoAvion;
	}

	public void setTipoAvion(Tipo_Avion tipoAvion) {
		this.tipoAvion = tipoAvion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Date getFecPartida() {
		return fecPartida;
	}

	public void setFecPartida(Date fecPartida) {
		this.fecPartida = fecPartida;
	}

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Date getFecDestino() {
		return fecDestino;
	}

	public void setFecDestino(Date fecDestino) {
		this.fecDestino = fecDestino;
	}

	public String getHoraDestino() {
		return horaDestino;
	}

	public void setHoraDestino(String horaDestino) {
		this.horaDestino = horaDestino;
	}

	public Tipo_Vuelo getTipoVuelo() {
		return tipoVuelo;
	}

	public void setTipoVuelo(Tipo_Vuelo tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}

	
	
	
	
}


