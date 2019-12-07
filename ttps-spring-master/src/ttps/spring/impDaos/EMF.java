package ttps.spring.impDaos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("veterinariaPersistencia");

	public static EntityManagerFactory getEMF() {
		return em;
	}
}