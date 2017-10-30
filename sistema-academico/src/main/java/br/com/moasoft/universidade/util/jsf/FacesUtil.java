/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author danil
 */
public class FacesUtil {
    public static void addMessage(String message, FacesMessage.Severity severity) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, message));
    }

    public static void addErrorMessage(String message) {
        addMessage(message, FacesMessage.SEVERITY_ERROR);
    }

    public static void addInfoMessage(String message) {
        addMessage(message, FacesMessage.SEVERITY_INFO);
    }

    public static boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }
}
