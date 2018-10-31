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
@Table(name="tb_laboratorio")
public class Laboratorio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_lab")
	private int codLaboratorio;
	@Column(name="des_lab")
	private String nomLaboratorio;
	@OneToMany(mappedBy="laboratorio")
	private List<Medicamento> listaMedicamentos;
	
	@OneToMany(mappedBy="laboratorio")
	private List<TipoMedicamento> listaTipoMedicamento;
	
	@OneToMany(mappedBy="laboratorio")
	private List<Modelo> listaModelo;
	
	
	
	public Laboratorio(){
		
	}
	public int getCodLaboratorio() {
		return codLaboratorio;
	}
	public void setCodLaboratorio(int codLaboratorio) {
		this.codLaboratorio = codLaboratorio;
	}
	public String getNomLaboratorio() {
		return nomLaboratorio;
	}
	public void setNomLaboratorio(String nomLaboratorio) {
		this.nomLaboratorio = nomLaboratorio;
	}
	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}
	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
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

