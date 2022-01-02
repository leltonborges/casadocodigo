package br.com.casadocodigo.loja.converters;

import br.com.casadocodigo.loja.models.Autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String id) {
        if(id.equals(null) || id.trim().isEmpty()) return null;

        System.out.println("Converte to obj: "+ id);
        Autor autor = new Autor();
        autor.setId(Integer.valueOf(id));
        return autor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object autorObj) {
        if (autorObj.equals(null)) return null;

        System.out.println("Converte to string: "+ autorObj);
        Autor autor = (Autor) autorObj;
        return autor.getId().toString();
    }
}
