import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Auteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	private String Nom;
	@Basic
	private String Domaine;
	
	@OneToMany
	private List<Article> articles = new ArrayList<>();
	
	public List<Article> getArticles(){
		return this.articles;
	}
}
