/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.metatron.dao;

import br.com.metatron.api.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author diego
 */
public class UsuarioDAOHibernate implements UsuarioDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public Usuario find(Long id) throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            Usuario usuario = (Usuario) session.get(Usuario.class, id);
            return usuario;
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = session.createQuery("from Usuario usuario")
                    .list();
            return usuarios;
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Usuario> findAllByNomeUsuarioNomeCargo(String nomeUsuario, String nomeCargo) throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            Criteria criteria = session.createCriteria(Usuario.class);

            if (nomeUsuario != null && !"".equals(nomeUsuario)) {
                criteria.add(Restrictions.ilike("nome", "%" + nomeUsuario + "%"));
            }
            if (nomeCargo!= null && !"".equals(nomeCargo)) {
                criteria.add(Restrictions.ilike("cargo.nome", "%" + nomeCargo + "%"));
            }

            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = criteria.list();
            
            return usuarios;
        } catch (HibernateException e) {
            throw e;
        }
    }

}
