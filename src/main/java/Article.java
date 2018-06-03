import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<Article> article = new ArrayList<>();

	@ManyToMany(mappedBy = "article")
	private List<Article> articleReferents = new ArrayList<>();
	
	@OneToMany
	private List<Auteur> auteurs = new ArrayList<>();
	
	@Basic
	private String Titre;
	
	@Basic
	private String Contenu;
	
	public List<Auteur> getAuteurs(){
		return this.auteurs;
	}
}
