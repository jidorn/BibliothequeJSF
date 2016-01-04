package fr.afcepf.al26.jee.jsf.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al26.bibliotheque.entity.Auteur;
import fr.afcepf.al26.bibliotheque.entity.Livre;
import fr.afcepf.al26.bibliotheque.idao.IDaoAuteur;
import fr.afcepf.al26.bibliotheque.idao.IDaoLivre;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoAuteur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoLivre;
import org.apache.log4j.Logger;

@ManagedBean(name = "mbAjoutLivre")
@RequestScoped
public class AjoutLivreMb {

	@ManagedProperty(value = "#{mbAjoutAuteur.auteur}")
	private Auteur auteur;
	private Logger log = Logger.getLogger(AjoutLivreMb.class);
	private Livre livre = new Livre();
	private List<Auteur> listAuteurs;

	public AjoutLivreMb() {
		IDaoAuteur daoAuteur = new DaoAuteur();
		listAuteurs = daoAuteur.getAuteurs();
	}

	@PostConstruct
	public void init() {
		livre.setAuteur(auteur);
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public List<Auteur> getListAuteurs() {
		return listAuteurs;
	}

	public void setListAuteurs(List<Auteur> listAuteurs) {
		this.listAuteurs = listAuteurs;
	}

	public String ajouterLivre() {
		IDaoLivre daoLivre = new DaoLivre();
		daoLivre.ajouterLivre(livre);
		return "";
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
}
