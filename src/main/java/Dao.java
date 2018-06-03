import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	public static void main( String[] args ) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		
	}
	public void addCentre(CentreRecherche centre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(centre);
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	public CentreRecherche getCentre(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			CentreRecherche centre = null;
			centre =  (CentreRecherche) entityManager.createQuery("select * from centre where cen_nom = ':name'").setParameter("name", name).getResultList();
			entityManager.getTransaction().commit();
			return centre;
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	public void addUser(Auteur auteur) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(auteur);
			List<Article> articles = auteur.getArticles();
			Integer max = articles.size();
			for(Integer x = 0;x<max;x++) {
				entityManager.persist(articles.get(x));
			}
			entityManager.getTransaction().commit();
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticleBySpecif(String specif){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			List<Article> listArticle = null;
			listArticle =  entityManager.createQuery("select * from article inner join art_aut using art_id inner join auteur using aut_id where auteur.aut_domaine = ':specif'").setParameter("specif", specif).getResultList();
			entityManager.getTransaction().commit();
			return listArticle;
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Article> getArticleByCountry(String country){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd");
		EntityManager entityManager = emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			List<Article> listArticle = null;
			listArticle =  entityManager.createQuery("select * from article inner join art_aut using art_id inner join auteur using aut_id inner joint centre using cen_id where centre.cen_pays = ':country'").setParameter("country", country).getResultList();
			entityManager.getTransaction().commit();
			return listArticle;
		}
		finally {
		  entityManager.close();
		  emf.close();
		}
	}
	public void updateRef() {
		
	}
}