/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Departamento;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Departamentos {
    public Departamento salvar(Departamento departamento);
    public List<Departamento> todos();
    public Departamento porCodigo(Integer codigo);
    public void remover(Departamento departamento);
}
