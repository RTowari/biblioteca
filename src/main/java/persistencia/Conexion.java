package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import interfaces.Fabrica;
import interfaces.IControlador;

public class Conexion {
	private static Conexion instancia = null;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private Conexion(){}
	
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
			emf = Persistence.createEntityManagerFactory("MiUnidadRender");
			em=emf.createEntityManager();
		}
		return instancia;
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public void close() {
		this.em.close();
		this.emf.close();
	}


}
