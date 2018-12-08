package br.com.metatron.api.dao;

import br.com.metatron.api.model.Usuario;
import java.util.List;

/**
 *
 * @author diego
 */
public interface UsuarioDAO {
    List<Usuario> findAllByNomeUsuarioNomeCargo(String nomeUsuario, String nomeCargo) throws Exception;
}
