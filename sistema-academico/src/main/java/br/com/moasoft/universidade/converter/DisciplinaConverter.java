/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.converter;

import br.com.moasoft.universidade.model.Disciplina;
import br.com.moasoft.universidade.repository.Disciplinas;
import br.com.moasoft.universidade.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author danil
 */

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {
    
    private Disciplinas disciplinas;

    public DisciplinaConverter() {
        this.disciplinas = CDIServiceLocator.getBean(Disciplinas.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (StringUtils.isNotBlank(value)) {
            Integer codigo = new Integer(value);
            return this.disciplinas.porCodigo(codigo);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        if (obj != null) {
            Disciplina disciplina = (Disciplina) obj;
            return disciplina.getCodigo().toString();
        }
        return null;
    }
    
}
