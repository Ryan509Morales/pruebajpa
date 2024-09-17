package com.ciberfarma.app;

import java.util.List;

import com.ciberfarma.model.Tipo;
import com.ciberfarma.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo07 {
	//Listado de los tipos de usuario y sus usuarios
	public static void main(String[] args) {
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = conexion.createEntityManager();
		
		//sql = select * from tb_tipos
		//jpql = "select u from Tipo u"
		List<Tipo> lstTipo = em.createNamedQuery("select * from tb_tipos", Tipo.class).
				getResultList(); //usando una sentencia normal de sql
		
		for (Tipo t : lstTipo) {
			System.out.print("Tipo de usuario: " + t.getDescripcion());
			System.out.println("--------------");
			for (Usuario u : t.getListUsuarios()) {
				System.out.print("Nombre: " + u.getNom_usua()+ "" + u.getNom_usua());
				System.out.print("Email: " + u.getCorreo());
			}
		}
		
		
		List<Tipo> lstTipo2 = em.createQuery("select u from Tipo u").getResultList(); // usando una sentencia jpql
		for (Tipo t : lstTipo2) {
			System.out.print("Tipo de Usuario:" + t.getDescripcion());
			System.out.print("------------");
			for (Usuario u : t.getListUsuarios()) {
				System.out.print("Nombre: " + u.getNom_usua()+ "" + u.getNom_usua());
				System.out.print("Email: " + u.getCorreo());
			}
		}
		
	}
}
