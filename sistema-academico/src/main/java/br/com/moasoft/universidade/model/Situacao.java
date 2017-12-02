/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

/**
 *
 * @author danil
 */
public enum Situacao {
    ATIVA("Ativa"),
    TRANCADA("Trancada"),
    ENCERRADA("Encerrada");
    
    private String descricao;

    private Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
