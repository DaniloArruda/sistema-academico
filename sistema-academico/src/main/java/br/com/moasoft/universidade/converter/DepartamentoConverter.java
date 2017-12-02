/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.converter;

import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.repository.Departamentos;
import br.com.moasoft.universidade.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author danil
 */

@FacesConverter(forClass = Departamento.class)
public class DepartamentoConverter implements Converter {

    //@Inject
    private Departamentos departamentos;

    public DepartamentoConverter() {
        this.departamentos = CDIServiceLocator.getBean(Departamentos.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (StringUtils.isNotBlank(value)) {
            Integer codigo = new Integer(value);
            return departamentos.porCodigo(codigo);
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return ((Departamento) object).getCodigo().toString();
        }
        
        return "";
    }
    
}
