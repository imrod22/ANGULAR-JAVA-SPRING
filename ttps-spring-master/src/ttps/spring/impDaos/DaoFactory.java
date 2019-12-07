package ttps.spring.impDaos;

import ttps.spring.daos.*;

public class DaoFactory {
	
	public static InformacionDAO getInformacionDAO() {
		
		return new InformacionDAOHibernateJPA();
	}
	
	public static TipoEventoDAO getTipoEventoDAO() {
		
		return new TipoEventoDAOHibernateJPA();
	}
	
	public static EventoDAO getEventoDAO() {
		
		return new EventoDAOHibernateJPA();
	}
	
	public static MascotaDAO getMascotaDAO() {
		
		return new MascotaDAOHibernateJPA();
	}
	
	public static CampoFichaDAO getCampoFichaDAO() {
		
		return new CampoFichaDAOHibernateJPA();
	}
	
	public static NombreCampoDAO getNombreCampoDAO() {
		
		return new NombreCampoDAOHibernateJPA();
	}
	
	public static RazaDAO getRazaDAO() {
		
		return new RazaDAOHibernateJPA();
	}
	
	public static EspecieDAO getEspecieDAO() {
		
		return new EspecieDAOHibernateJPA();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		
		return new UsuarioDAOHibernateJPA();
	}
	
	public static TipoUsuarioDAO getTipoUsuarioDAO() {
		
		return new TipoUsuarioDAOHibernateJPA();
	}
	
	public static InformacionVeterinariaDAO getInformacionVeterinariaDAO() {
		
		return new InformacionVeterinariaDAOHibernateJPA();
	}
}