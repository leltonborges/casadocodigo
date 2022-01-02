package br.com.casadocodigo.loja.conf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesContextProducer {
    private FacesContext facesContext;

    @PostConstruct
    public void init() {
        this.facesContext = FacesContext.getCurrentInstance();
    }

    @RequestScoped
    @Produces
    public FacesContext getFacesContext() {
        return this.facesContext;
    }

    @RequestScoped
    @Produces
    public Flash getFlash(){
        return this.facesContext.getExternalContext().getFlash();
    }
}
