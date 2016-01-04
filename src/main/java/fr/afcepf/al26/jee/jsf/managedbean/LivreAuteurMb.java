package fr.afcepf.al26.jee.jsf.managedbean;

import fr.afcepf.al26.bibliotheque.entity.Auteur;
import fr.afcepf.al26.bibliotheque.entity.Livre;
import fr.afcepf.al26.bibliotheque.idao.IDaoAuteur;
import fr.afcepf.al26.bibliotheque.idao.IDaoLivre;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoAuteur;
import fr.afcepf.al26.bibliotheque.jdbc.dao.DaoLivre;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Stagiaire on 04/01/2016.
 */

@ManagedBean(name = "mbLivresAuteur")
@SessionScoped
public class LivreAuteurMb {

    private Logger log = Logger.getLogger(LivreAuteurMb.class);
    private Auteur auteur;
    private List<Livre> livreList;

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
    }

    public String recupLivreAuteur(int idAuteur) {
        IDaoAuteur daoAuteur = new DaoAuteur();
        auteur = daoAuteur.getAuteursById(idAuteur);
        if (auteur != null) {
            IDaoLivre daoLivre = new DaoLivre();
            livreList = daoLivre.getLivreParAuteur(idAuteur);
            log.info("livreList : "+livreList);
            return "/livresAuteur.xhtml?faces-redirect=true";
        }
        return "";
    }
}
