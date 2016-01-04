package fr.afcepf.al26.jee.jsf.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al26.bibliotheque.entity.Auteur;
import fr.afcepf.al26.bibliotheque.idao.IDaoAuteur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoAuteur;
import org.apache.log4j.Logger;

@ManagedBean(name = "mbRechercheAuteur")
@SessionScoped
public class RechercheAuteurMb {

    private String nomRecherche;
    private List<Auteur> listeAuteurs;

    public String getNomRecherche() {
        return nomRecherche;
    }

    public void setNomRecherche(String nomRecherche) {
        this.nomRecherche = nomRecherche;
    }

    public List<Auteur> getListeAuteurs() {
        return listeAuteurs;
    }

    public void setListeAuteurs(List<Auteur> listeAuteurs) {
        this.listeAuteurs = listeAuteurs;
    }

    public String rechercher() {
        IDaoAuteur daoAuteur = new DaoAuteur();
        listeAuteurs =
                daoAuteur.rechercherAuteurParNom(nomRecherche);
        return "";
    }
}
