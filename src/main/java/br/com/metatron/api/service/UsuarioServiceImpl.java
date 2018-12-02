package br.com.metatron.api.service;

import br.com.metatron.api.model.Usuario;
import br.com.metatron.dao.UsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * Implemanta todos os serviços relacionados aos usuários
 *
 * @author diego
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO dao;

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usuario = null;
        try {
            usuario = dao.find(id);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        List<Usuario> usuarios = null;
        try {
            usuarios = dao.findAll();           
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> findAllUsuariosByNomeUsuarioNomeCargo(String nomeUsuario, String nomeCargo) {
        List<Usuario> usuarios = null;
        try {
            usuarios = dao.findAllByNomeUsuarioNomeCargo(nomeUsuario, nomeCargo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

}
