package br.com.metatron.api.service;

import br.com.metatron.api.model.Usuario;
import java.util.List;

/**
 * Define todos os serviços relacionados aos usuários
 * @author diego
 */
public interface UsuarioService {
    Usuario findUsuario(Long id);
    List<Usuario> findAllUsuarios();
    List<Usuario> findAllUsuariosByNomeUsuarioNomeCargo(String nomeUsuario, String nomeCargo);
}
