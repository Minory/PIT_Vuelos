package com.laboratorio.pruebas;

import java.io.FileOutputStream;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.farmacia.entidad.Laboratorio;
import com.farmacia.entidad.Medicamento;
import com.farmacia.model.modelLaboratorio;
import com.farmacia.model.modelMedicamento;

public class Prueba01 {
	public static void main(String[] args) {
		//Registra
		/*Laboratorio obj=new Laboratorio();
		obj.setDesLaboratorio("C");
		new modelLaboratorio().addLaboratorio(obj);
		*/
		
		//Actualiza
		/*Laboratorio obj=new Laboratorio();
		obj.setCodLaboratorio(1);
		obj.setDesLaboratorio("A");
		new modelLaboratorio().modifyLaboratorio(obj);
		*/
		
		//Elimina
		//new modelLaboratorio().deleteLaboratorio(1);
		
		//Buscar
		//List<Laboratorio> x=new modelLaboratorio().listaLaboratorio();
		//for(Laboratorio l:x)
		//	System.out.println(l.getCodLaboratorio());
		//System.out.println(l.getNomLaboratorio());
		//Foto
		final byte[]foto=null;
		Medicamento m=new modelMedicamento().findMedicamento(5);
		System.out.println(m.getCodMedicamento());
		System.out.println(m.getFoto());
		//1 Obtiene la ruta del servidor
				//ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				//String realPath=(String) servletContext.getRealPath("/"); 
				String imagen;
				//2 Construye el archivo con los bytes que esta en la BD 
				try {
					String rutaFile = "d:\\"+ m.getCodMedicamento() +".jpg";
					imagen= m.getCodMedicamento() +".jpg";
					
					System.out.println("Imagen -> " + rutaFile);
					
					FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
					fileOuputStream.write(m.getFoto());
					fileOuputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
