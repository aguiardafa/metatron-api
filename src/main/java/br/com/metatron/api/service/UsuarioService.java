package br.com.metatron.api.service;

import br.com.metatron.api.model.Usuario;
import java.util.List;

/**
 * Define todos os serviços relacionados aos usuários
 * @author diego
 */
public interface UsuarioService {
    List<Usuario> findAllUsuarios(String nomeUsuario, String nomeCargo);
}
