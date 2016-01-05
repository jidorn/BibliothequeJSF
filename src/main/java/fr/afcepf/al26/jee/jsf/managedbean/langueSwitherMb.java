package fr.afcepf.al26.jee.jsf.managedbean;

import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 * Created by Stagiaire on 05/01/2016.
 */

@ManagedBean(name = "switcher")
@SessionScoped
public class LangueSwitherMb {

    public Logger log = Logger.getLogger(LangueSwitherMb.class);

    public String switchLocale(String lang) {
        if (!lang.equals("fr")) {
            log.info("je passe avant par :" + FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
            log.info("je passe apres par :"+FacesContext.getCurrentInstance().getViewRoot().getLocale());
        } else {
            log.info("je passe avant par :"+FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
            log.info("je passe apres par :" + FacesContext.getCurrentInstance().getViewRoot().getLocale());
        }
        return "";
    }
}
