package br.com.metatron.api.service;

import br.com.metatron.api.model.Usuario;
import br.com.metatron.api.dao.UsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implemanta os serviços relacionados aos usuários
 *
 * @author diego
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    @Override
    @Transactional
    public List<Usuario> findAllUsuarios(String nomeUsuario, String nomeCargo) {
        List<Usuario> usuarios = null;
        try {
            usuarios = dao.findAllByNomeUsuarioNomeCargo(nomeUsuario, nomeCargo);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

}
