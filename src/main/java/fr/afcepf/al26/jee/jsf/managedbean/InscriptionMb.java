package fr.afcepf.al26.jee.jsf.managedbean;

import fr.afcepf.al26.bibliotheque.business.BusinessUtilisateur;
import fr.afcepf.al26.bibliotheque.entity.Utilisateur;
import fr.afcepf.al26.bibliotheque.ibusiness.IBusinessUtilisateur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Stagiaire on 05/01/2016.
 */

@ManagedBean
@RequestScoped
public class InscriptionMb {
    private Utilisateur utilisateur = new Utilisateur();
    private String message = "";

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String inscrireUtilisateur(){
        IBusinessUtilisateur businessUtilisateur = new BusinessUtilisateur();
        message = businessUtilisateur.ajouterUtilisateur(utilisateur);

        return "/rechercheAuteur.xhtml?faces-redirect=true";
    }
}
