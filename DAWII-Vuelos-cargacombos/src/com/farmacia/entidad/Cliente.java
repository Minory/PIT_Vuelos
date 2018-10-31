package com.farmacia.entidad;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cli")
	private int codCliente;
	@Column(name="nom_cli")
	private String nomCliente;
	@Column(name="ape_cli")
	private String apeCliente;
	@Column(name="sex_cli")
	private String sexCliente;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg_cli")
	private Date fecRegistro;
	@Column(name="dir_cli")
	private String dirCliente;
	@OneToMany(mappedBy="cliente")
	private List<Boleta> listaBoleta;
	@ManyToOne
	@JoinColumn(name="cod_dis_cli")
	private Distrito distrito;
	public Cliente(){
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApeCliente() {
		return apeCliente;
	}
	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}
	public String getSexCliente() {
		return sexCliente;
	}
	public void setSexCliente(String sexCliente) {
		this.sexCliente = sexCliente;
	}
	public Date getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	public String getDirCliente() {
		return dirCliente;
	}
	public void setDirCliente(String dirCliente) {
		this.dirCliente = dirCliente;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	public List<Boleta> getListaBoleta() {
		return listaBoleta;
	}
	public void setListaBoleta(List<Boleta> listaBoleta) {
		this.listaBoleta = listaBoleta;
	}
	
}

