package com.farmacia.action;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.FileOutputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.api.UIData;
import org.primefaces.event.FileUploadEvent;
import com.farmacia.entidad.Laboratorio;
import com.farmacia.entidad.Medicamento;
import com.farmacia.entidad.Modelo;
import com.farmacia.entidad.TipoMedicamento;
import com.farmacia.model.modelLaboratorio;
import com.farmacia.model.modelMedicamento;
import com.farmacia.model.modelTipoMedicamento;
@ManagedBean(name="CRUDMedicamento")
@ViewScoped
public class MedicamentoAction {
	private List<Medicamento> listaMedicamento;
	private List<Laboratorio> listaLaboratorio;
	private List<TipoMedicamento> listaTipoMedicamento;
	private List<Modelo> listaModelo;
	
	private Medicamento medicamento;
	private UIData dtFila;
	
	public MedicamentoAction(){
		medicamento=new Medicamento();
	}
	public void registra(){
		new modelMedicamento().addMedicamento(medicamento);
		medicamento=new Medicamento();
	}
	public void nuevo(){
		medicamento=new Medicamento();
	}
	public void busca(){
		medicamento=(Medicamento) dtFila.getRowData();
		listaTipoMedicamento=new modelTipoMedicamento().listTipoMedicamento(medicamento.getLaboratorio().getCodLaboratorio());
	}
	public void cargarTipoMedicamento(){
		listaTipoMedicamento=new modelTipoMedicamento().listTipoMedicamento(medicamento.getLaboratorio().getCodLaboratorio());
	}
	
	public void cargarModelo(){
		listaModelo=new modelTipoMedicamento().listModelo(
					medicamento.getLaboratorio().getCodLaboratorio(),
					medicamento.getTipoMedicamento().getCodTipoMedicamento());
	}
	
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
	}
	public List<Medicamento> getListaMedicamento() {
		listaMedicamento=new modelMedicamento().listaMedicamento();
		return listaMedicamento;
	}
	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	public List<Laboratorio> getListaLaboratorio() {
		listaLaboratorio=new modelLaboratorio().listaLaboratorio();
		return listaLaboratorio;
	}
	public void setListaLaboratorio(List<Laboratorio> listaLaboratorio) {
		this.listaLaboratorio = listaLaboratorio;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	public List<TipoMedicamento> getListaTipoMedicamento() {
		return listaTipoMedicamento;
	}
	public void setListaTipoMedicamento(List<TipoMedicamento> listaTipoMedicamento) {
		this.listaTipoMedicamento = listaTipoMedicamento;
	}
	public List<Modelo> getListaModelo() {
		return listaModelo;
	}
	public void setListaModelo(List<Modelo> listaModelo) {
		this.listaModelo = listaModelo;
	}
	
}
