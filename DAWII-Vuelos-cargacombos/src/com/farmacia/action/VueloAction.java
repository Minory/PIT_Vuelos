package com.farmacia.action;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.api.UIData;
import org.primefaces.event.FileUploadEvent;

import com.farmacia.entidad.Aerolinea;
import com.farmacia.entidad.Aeropuerto;
import com.farmacia.entidad.Ciudad;
import com.farmacia.entidad.Laboratorio;
import com.farmacia.entidad.Medicamento;
import com.farmacia.entidad.Modelo;
import com.farmacia.entidad.Pais;
import com.farmacia.entidad.TipoMedicamento;
import com.farmacia.entidad.Tipo_Avion;
import com.farmacia.entidad.Tipo_Vuelo;
import com.farmacia.entidad.Vuelo;
import com.farmacia.model.modelAerolinea;
import com.farmacia.model.modelCiudad;
import com.farmacia.model.modelLaboratorio;
import com.farmacia.model.modelMedicamento;
import com.farmacia.model.modelPais;
import com.farmacia.model.modelTipoAvion;
import com.farmacia.model.modelTipoMedicamento;
import com.farmacia.model.modelTipoVuelo;
import com.farmacia.model.modelVuelo;
@ManagedBean(name="CRUDVuelo")
@ViewScoped
public class VueloAction {
	private List<Vuelo> listaVuelo;
	private List<Vuelo> listaVuelo2;
	private List<Pais> listaPais;
	private List<Ciudad> listaCiudadB1;
	private List<Ciudad> listaCiudadB2;
	private List<Ciudad> listaCiudad1;
	private List<Ciudad> listaCiudad2;
	private List<Aeropuerto> listaAeropuerto1;
	private List<Aeropuerto> listaAeropuerto2;
	private List<Aerolinea> listaAerolinea;
	private List<Tipo_Vuelo> listaTipoVuelo;
	private List<Tipo_Avion> listaTipoAvion;
	
	
	private Vuelo vuelo;
	private UIData dtFila;
	private String codPais1;
	private String codCiudad1;
	private String codCiudad2;
	private String codPais2;
	private Date fechap;
	private String codTipoVuelo;
	
	public VueloAction(){
		vuelo=new Vuelo();
	}
	public void registra(){
		new modelVuelo().addVuelo(vuelo);
		vuelo=new Vuelo();
	}
	public void nuevo(){
		vuelo=new Vuelo();
	}
	public void busca(){
		vuelo=(Vuelo) dtFila.getRowData();
		//listaCiudad=new modelCiudad().listCiudad(vuelo.getCiudad().getCodCiudad());
	}
	
	public void buscaVuelos(){		
		listaVuelo2=new modelVuelo().BuscarVuelo(Integer.parseInt(codPais1),Integer.parseInt(codCiudad1)
				,Integer.parseInt(codPais2),Integer.parseInt(codCiudad2),
				fechap,Integer.parseInt(codTipoVuelo)); 
		//,Integer.parseInt(codPais2, fechap, Integer.parseInt(codTipoVuelo)
	}
	
	
	public void cargarCiudadBuscar1(){
		listaCiudadB1=new modelCiudad().listCiudad(Integer.parseInt(codPais1));
	}
	
	public void cargarCiudadBuscar2(){
		listaCiudadB2=new modelCiudad().listCiudad(Integer.parseInt(codPais2));
	}
	public void cargarCiudad1(){
		listaCiudad1=new modelCiudad().listCiudad(vuelo.getPais1().getCodPais());
	}
	
	public void cargarCiudad2(){
		listaCiudad2=new modelCiudad().listCiudad(vuelo.getPais2().getCodPais());
	}
	public void cargarAeropuerto1(){
		listaAeropuerto1=new modelCiudad().listAeropuerto(
					vuelo.getPais1().getCodPais(),
					vuelo.getCiudad1().getCodCiudad());
	}
	public void cargarAeropuerto2(){
		listaAeropuerto2=new modelCiudad().listAeropuerto(
					vuelo.getPais2().getCodPais(),
					vuelo.getCiudad2().getCodCiudad());
	}
	
	public void cargarTipoAvion(){
		listaTipoAvion=new modelTipoAvion().listTipoAvion(vuelo.getAerolinea().getCodAerolinea());
	}
	
	/*
	public void buscarEditar(){
		medicamento=(Medicamento) dtFila.getRowData();
		listaTipoMedicamento=new modelTipoMedicamento().listTipoMedicamento(medicamento.getLaboratorio().getCodLaboratorio());
		listaModelo=new modelTipoMedicamento().listModelo(
				medicamento.getLaboratorio().getCodLaboratorio(),
				medicamento.getTipoMedicamento().getCodTipoMedicamento());
		mostrarImagen();
	}
	public void subirImagen(FileUploadEvent event){
		medicamento.setFoto(event.getFile().getContents());
		mostrarImagen();
	}
	public void mostrarImagen(){
		//1 Obtiene la ruta del servidor
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("/"); 
		//2 Construye el archivo con los bytes que esta en la BD 
		try {
				String rutaFile = realPath+"\\"+ medicamento.getCodMedicamento() +".jpg";
				medicamento.setImagen(medicamento.getCodMedicamento() +".jpg");
				System.out.println("Imagen -> " + rutaFile);
				FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
				fileOuputStream.write(medicamento.getFoto());
				fileOuputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
		}		
	}	
	public void actualiza(){
		new modelMedicamento().modifyMedicamento(medicamento);
	}
	public void elimina(){
		new modelMedicamento().deleteMedicamento(medicamento.getCodMedicamento());
	}*/
	/*public List<Medicamento> getListaMedicamento() {
		listaMedicamento=new modelMedicamento().listaMedicamento();
		return listaMedicamento;
	}*/
	
	/*public List<Laboratorio> getListaLaboratorio() {
		listaLaboratorio=new modelLaboratorio().listaLaboratorio();
		return listaLaboratorio;
	}*/
	
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	public List<Vuelo> getListaVuelo() {
		listaVuelo=new modelVuelo().listaVuelo();
		return listaVuelo;
	}
	public void setListaVuelo(List<Vuelo> listaVuelo) {
		this.listaVuelo = listaVuelo;
	}
	public List<Pais> getListaPais() {
		listaPais=new modelPais().listaPais();
		return listaPais;
	}
	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}
	
	public List<Ciudad> getListaCiudad1() {
		return listaCiudad1;
	}
	public void setListaCiudad1(List<Ciudad> listaCiudad1) {
		this.listaCiudad1 = listaCiudad1;
	}
	public List<Ciudad> getListaCiudad2() {
		return listaCiudad2;
	}
	public void setListaCiudad2(List<Ciudad> listaCiudad2) {
		this.listaCiudad2 = listaCiudad2;
	}
	
	public List<Aeropuerto> getListaAeropuerto1() {
		return listaAeropuerto1;
	}
	public void setListaAeropuerto1(List<Aeropuerto> listaAeropuerto1) {
		this.listaAeropuerto1 = listaAeropuerto1;
	}
	public List<Aeropuerto> getListaAeropuerto2() {
		return listaAeropuerto2;
	}
	public void setListaAeropuerto2(List<Aeropuerto> listaAeropuerto2) {
		this.listaAeropuerto2 = listaAeropuerto2;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public List<Aerolinea> getListaAerolinea() {
		listaAerolinea=new modelAerolinea().listaAerolinea();
		return listaAerolinea;
	}
	public void setListaAerolinea(List<Aerolinea> listaAerolinea) {
		this.listaAerolinea = listaAerolinea;
	}
	public List<Tipo_Vuelo> getListaTipoVuelo() {
		listaTipoVuelo=new modelTipoVuelo().listaTipoVuelo();
		return listaTipoVuelo;
	}
	public void setListaTipoVuelo(List<Tipo_Vuelo> listaTipoVuelo) {
		this.listaTipoVuelo = listaTipoVuelo;
	}
	public List<Tipo_Avion> getListaTipoAvion() {
		return listaTipoAvion;
	}
	public void setListaTipoAvion(List<Tipo_Avion> listaTipoAvion) {
		this.listaTipoAvion = listaTipoAvion;
	}
	public String getCodPais1() {
		return codPais1;
	}
	public void setCodPais1(String codPais1) {
		this.codPais1 = codPais1;
	}
	public String getCodPais2() {
		return codPais2;
	}
	public void setCodPais2(String codPais2) {
		this.codPais2 = codPais2;
	}
	public Date getFechap() {
		return fechap;
	}
	public void setFechap(Date fechap) {
		this.fechap = fechap;
	}
	public String getCodTipoVuelo() {
		return codTipoVuelo;
	}
	public void setCodTipoVuelo(String codTipoVuelo) {
		this.codTipoVuelo = codTipoVuelo;
	}
	public List<Vuelo> getListaVuelo2() {
		return listaVuelo2;
	}
	public void setListaVuelo2(List<Vuelo> listaVuelo2) {
		this.listaVuelo2 = listaVuelo2;
	}
	public String getCodCiudad1() {
		return codCiudad1;
	}
	public void setCodCiudad1(String codCiudad1) {
		this.codCiudad1 = codCiudad1;
	}
	public List<Ciudad> getListaCiudadB1() {
		return listaCiudadB1;
	}
	public void setListaCiudadB1(List<Ciudad> listaCiudadB1) {
		this.listaCiudadB1 = listaCiudadB1;
	}
	public List<Ciudad> getListaCiudadB2() {
		return listaCiudadB2;
	}
	public void setListaCiudadB2(List<Ciudad> listaCiudadB2) {
		this.listaCiudadB2 = listaCiudadB2;
	}
	public String getCodCiudad2() {
		return codCiudad2;
	}
	public void setCodCiudad2(String codCiudad2) {
		this.codCiudad2 = codCiudad2;
	}
	
	
	
}
