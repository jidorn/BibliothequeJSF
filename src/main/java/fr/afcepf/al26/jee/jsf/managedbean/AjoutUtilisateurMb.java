package fr.afcepf.al26.jee.jsf.managedbean;

import fr.afcepf.al26.bibliotheque.entity.Utilisateur;
import fr.afcepf.al26.bibliotheque.idao.IDaoUtilisateur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoUtilisateur;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Stagiaire on 04/01/2016.
 */

@ManagedBean(name = "mbAjoutUtilisateur")
@SessionScoped
public class AjoutUtilisateurMb {
    private Logger log = Logger.getLogger(AjoutUtilisateurMb.class);
    private Utilisateur utilisateur = new Utilisateur();

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String ajoutUtilisateur(){
        IDaoUtilisateur daoUtilisateur = new DaoUtilisateur();
        daoUtilisateur.ajouterUtilisateur(utilisateur);
        log.info("utilisateur : "+utilisateur.getIdUtilisateur());
        return "/rechercheAuteur.xhtml?faces-redirect=true";
    }
}
