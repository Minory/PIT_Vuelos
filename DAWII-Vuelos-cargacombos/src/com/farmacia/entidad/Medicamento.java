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
@Table(name="tb_medicamento")
public class Medicamento implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_med")
	private int codMedicamento;
	@Column(name="nom_med")
	private String nomMedicamento;
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	@Column(name="stock_med")
	private int stock;
	@Column(name="pre_med")
	private double precio;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_ven_med")
	private Date fecVencimiento;
	@Column
	private byte[]foto;
	//Atributo adicional para mostrar la imagen
	//No sesta en la base de datos
	//No se considera en el mapeo con  los campos de la tabla
	@Transient
	private String imagen;
	@OneToMany(mappedBy="medicamento")
	private List<MedicamentoHasBoleta> medicamentoBoleta;
	@ManyToOne
	@JoinColumn(name="cod_tip_med")
	private TipoMedicamento tipoMedicamento;
	@ManyToOne
	@JoinColumn(name="cod_modelo")
	private Modelo modelo;
	
	public Medicamento(){
		laboratorio=new Laboratorio();
		tipoMedicamento=new TipoMedicamento();
		modelo=new Modelo();
	}
	
	public int getCodMedicamento() {
		return codMedicamento;
	}
	public void setCodMedicamento(int codMedicamento) {
		this.codMedicamento = codMedicamento;
	}
	public String getNomMedicamento() {
		return nomMedicamento;
	}
	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecVencimiento() {
		return fecVencimiento;
	}
	public void setFecVencimiento(Date fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}
	public List<MedicamentoHasBoleta> getMedicamentoBoleta() {
		return medicamentoBoleta;
	}
	public void setMedicamentoBoleta(List<MedicamentoHasBoleta> medicamentoBoleta) {
		this.medicamentoBoleta = medicamentoBoleta;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getImagen() {
		/*
		//1 Obtiene la ruta del servidor
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("/"); 
		//2 Construye el archivo con los bytes que esta en la BD 
		try {
			String rutaFile = realPath+"\\"+ codMedicamento +".jpg";
			imagen= codMedicamento +".jpg";
			
			System.out.println("Imagen -> " + rutaFile);
			
			FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
			fileOuputStream.write(foto);
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}


