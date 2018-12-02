/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.metatron.dao;

import br.com.metatron.api.model.Usuario;
import java.util.List;

/**
 *
 * @author diego
 */
public interface UsuarioDAO {
    Usuario find(Long id) throws Exception;

    List<Usuario> findAll() throws Exception;
    
    List<Usuario> findAllByNomeUsuarioNomeCargo(String nomeUsuario, String nomeCargo) throws Exception;
}
