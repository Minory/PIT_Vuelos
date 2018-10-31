package com.farmacia.model;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Boleta;
import com.farmacia.entidad.Cliente;
import com.farmacia.entidad.Empleado;
import com.farmacia.entidad.MedicamentoHasBoleta;
import com.farmacia.entidad.MedicamentoHasBoletaPK;

public class modelBoleta {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public void registra(Boleta bol){
		manager=fabrica.createEntityManager();
		try {
			Boleta b=new Boleta();
			Cliente c=manager.find(Cliente.class, bol.getCliente().getCodCliente());
			b.setCliente(c);
			Empleado e=manager.find(Empleado.class, bol.getEmpleado().getCodEmpleado());
			b.setEmpleado(e);
			b.setFecEmision(new Date());
			b.setMontoBoleta(bol.getMontoBoleta());
			manager.getTransaction().begin();
			manager.persist(b);
			manager.flush();
			for(MedicamentoHasBoleta m:bol.getMedicamentoBoleta()){
				MedicamentoHasBoletaPK pk=new MedicamentoHasBoletaPK();
				pk.setNumBoleta(b.getNumBoleta());
				pk.setCodMedicamento(m.getId().getCodMedicamento());
				m.setId(pk);
				manager.persist(m);
				manager.flush();
			}
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
	/*public List<MedicamentoHasBoleta> listaBoleta(){
		EntityManager manager=fabrica.createEntityManager();
		String jpql="select mb from MedicamentoHasBoleta mb join mb.boleta b join mb.medicamento m join b.cliente c join b.empleado e";
		TypedQuery<MedicamentoHasBoleta> m=manager.createQuery(jpql,MedicamentoHasBoleta.class);
		return m.getResultList();
	}*/
	public List<MedicamentoHasBoleta> buscarXNumero(int num){
		EntityManager manager=fabrica.createEntityManager();
		List<MedicamentoHasBoleta> lista=null;
		try {
			String jpql="select mb from MedicamentoHasBoleta mb join mb.boleta b join mb.medicamento m join b.cliente c "+
					"join b.empleado e where b.numBoleta=?1";
			Query query=manager.createQuery(jpql,MedicamentoHasBoleta.class);
			query.setParameter(1, num);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return lista;
	}	
	
}
