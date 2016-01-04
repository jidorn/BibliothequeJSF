package fr.afcepf.al26.jee.jsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al26.bibliotheque.entity.Auteur;
import fr.afcepf.al26.bibliotheque.idao.IDaoAuteur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoAuteur;
import org.apache.log4j.Logger;


@ManagedBean(name = "mbAjoutAuteur")
@SessionScoped
public class AjoutAuteurMb {
	private Logger log = Logger.getLogger(AjoutAuteurMb.class);
	private Auteur auteur = new Auteur();

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public String ajoutAuteur() {
		IDaoAuteur daoAuteur = new DaoAuteur();
		daoAuteur.ajouterAuteur(auteur);
		log.info("auteur id : " + auteur.getIdAuteur());
		return "/ajoutLivre.xhtml?faces-redirect=true";
	}
}
