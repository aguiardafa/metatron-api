package br.com.metatron.api.dao;

import br.com.metatron.api.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author diego
 */
@Component
public class UsuarioDAOHibernate implements UsuarioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

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
                criteria.createAlias("cargo", "c");
                criteria.add(Restrictions.ilike("c.nome", "%" + nomeCargo + "%"));
            }

            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = criteria.list();
            
            return usuarios;
        } catch (HibernateException e) {
            throw e;
        }
    }

}
