package com.farmacia.entidad;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tb_distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_dis")
	private int codDistrito;
	@Column(name="nom_dis")
	private String nomDistrito;
	@OneToMany(mappedBy="distrito")
	private List<Empleado> empleados;
	@OneToMany(mappedBy="distrito")
	private List<Cliente> clientes; 
	public Distrito(){	
	}
	public int getCodDistrito() {
		return codDistrito;
	}
	public void setCodDistrito(int codDistrito) {
		this.codDistrito = codDistrito;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
}
