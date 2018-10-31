package com.farmacia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Modelo;
import com.farmacia.entidad.Vuelo;




public class modelVuelo {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public void addVuelo(Vuelo obj){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	/*
	public void modifyMedicamento(Medicamento obj){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public void deleteMedicamento(int cod){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			Medicamento obj=manager.find(Medicamento.class, cod);
			manager.remove(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public Medicamento findMedicamento(int cod){
		manager=fabrica.createEntityManager();
		Medicamento obj=null;
		try {
			obj=manager.find(Medicamento.class, cod);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
		return obj;
	}*/
	public List<Vuelo> listaVuelo(){
		EntityManager manager=fabrica.createEntityManager();
		String hql="FROM Vuelo";
		Query q=manager.createQuery(hql, Vuelo.class);
		List<Vuelo> lista=q.getResultList();
		manager.close();
		fabrica.close();
		return lista;
	}
	
	
	public List<Vuelo> BuscarVuelo(int cod1,int cod2,int cod3,int cod4,Date fechaP,int cod5){
		manager=fabrica.createEntityManager();
		String jpql="select m from Vuelo m where m.pais1.codPais=?1 "+
		" and m.ciudad1.codCiudad=?2 and m.pais2.codPais=?3 and m.ciudad2.codCiudad=?4"+
		" and m.fecPartida=?5  and m.tipoVuelo.codTipoVuelo=?6";
		Query t=manager.createQuery(jpql,Vuelo.class);
		t.setParameter(1, cod1);
		t.setParameter(2, cod2);
		t.setParameter(3, cod3);
		t.setParameter(4, cod4);
		t.setParameter(5, fechaP);		
		t.setParameter(6, cod5);
		
		List<Vuelo> lista=t.getResultList();
		manager.close();
		return lista;
	}
	
	
	
	/*
	public List<Vuelo> BuscarVuelo(int cod1){  //, ,int cod2,Date fechaP, int cod3
		manager=fabrica.createEntityManager();
		List<Vuelo> lista=null;
		try {
			String jpql=" select t1 from  Vuelo t1 where "+
					"t1.pais1.codPais=?1 ";//and t1.pais2.codPais=?2
			//and t1.fecPartida=?3 and " +
			//"t1.tipoVuelo.codTipoVuelo=?4
			Query q=manager.createQuery(jpql, Vuelo.class);
			q.setParameter(1, cod1);
			//q.setParameter(2, cod2);
			/*q.setParameter(2,fechaP);
			q.setParameter(4, cod3);*//*
			lista=q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();			
		}
		return lista;
	}
	*/
	
	/*public List<Modelo> listModelo(int codLab,int codTipo){
		manager=fabrica.createEntityManager();
		String jpql="select m from Modelo m where m.laboratorio.codLaboratorio=?1 and m.tipoMedicamento.codTipoMedicamento=?2";
		Query t=manager.createQuery(jpql,Modelo.class);
		t.setParameter(1, codLab);
		t.setParameter(2, codTipo);
		List<Modelo> lista=t.getResultList();
		manager.close();
		return lista;
	}*/
	
	
	
	
	/*
	public List<Medicamento> listaXNombreMedicamento(String nom){
		manager=fabrica.createEntityManager();
		String jpql="from Medicamento m where m.nomMedicamento like CONCAT(:param,'%')";
		List<Medicamento> lista=null;
		try {
			Query q=manager.createQuery(jpql, Medicamento.class);
			q.setParameter("param", nom);
			lista=q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();			
		}
		return lista;
	}
	public List<Medicamento> listaXNombreLaboratorio(String nom){
		manager=fabrica.createEntityManager();
		List<Medicamento> lista=null;
		try {
			String jpql="select m from Medicamento m where m.laboratorio.nomLaboratorio like CONCAT(:param,'%')";
			Query q=manager.createQuery(jpql, Medicamento.class);
			q.setParameter("param", nom);
			lista=q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();			
		}
		return lista;
	}
	public int actualizaPrecio(double incremento){
		EntityManager manager=fabrica.createEntityManager();
		String sql = " update Medicamento m set m.precio =m.precio+m.precio*?1";
		manager.getTransaction().begin();
		Query query = manager.createQuery(sql);
		query.setParameter(1, incremento);
		int salida = query.executeUpdate();
		manager.getTransaction().commit();
		return salida;
	}*/
}
