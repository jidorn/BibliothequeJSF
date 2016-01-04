package fr.afcepf.al26.jee.jsf.managedbean;

import fr.afcepf.al26.bibliotheque.entity.Utilisateur;
import fr.afcepf.al26.bibliotheque.idao.IDaoUtilisateur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoUtilisateur;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Stagiaire on 04/01/2016.
 */

@ManagedBean(name = "mbConnexionUtilisateur")
@SessionScoped
public class ConnexionUtilisateurMb {
    private Logger log = Logger.getLogger(ConnexionUtilisateurMb.class);
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String checkUtilisateur(){
        List<Utilisateur> utilisateurList= null;
        IDaoUtilisateur daoUtilisateur = new DaoUtilisateur();
        utilisateurList = daoUtilisateur.rechercherUtilisateurParPseudo(utilisateur.getPseudo());

        return "";
    }
}
