package fr.afcepf.al26.jee.jsf.managedbean;

import fr.afcepf.al26.bibliotheque.business.BusinessUtilisateur;
import fr.afcepf.al26.bibliotheque.entity.Utilisateur;
import fr.afcepf.al26.bibliotheque.ibusiness.IBusinessUtilisateur;
import fr.afcepf.al26.bibliotheque.idao.IDaoUtilisateur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoUtilisateur;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Stagiaire on 04/01/2016.
 */

@ManagedBean(name = "mbUtilisateur")
@SessionScoped
public class SessionUtilisateurMb {
    private Logger log = Logger.getLogger(SessionUtilisateurMb.class);
    private Utilisateur utilisateur;
    private String message;
    private String login;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String mdp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void connecter(Utilisateur utilisateur) {
        login = utilisateur.getMail();
        mdp = utilisateur.getMdp();
        connecter();
    }

    public String connecter() {
        IBusinessUtilisateur daoUtilisateur = new BusinessUtilisateur();
        utilisateur = daoUtilisateur.getUtilisateur(login, mdp);
        if (utilisateur != null)
            message = "Bonjour" + utilisateur.getPseudo();
        else
            message = "login/mdp faux";
        return "";
    }

    /**
     * methode qui va permettre de supprimer un utilisateur de la session afin de le déconnecter
     *
     * @return à la page d'accueil.
     */
    public String deconnecter() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "";
    }
}
