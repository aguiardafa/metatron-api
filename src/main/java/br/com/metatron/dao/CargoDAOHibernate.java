/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.metatron.dao;

import br.com.metatron.api.model.Cargo;
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
public class CargoDAOHibernate implements CargoDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public Cargo find(Long id) throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            Cargo cargo = (Cargo) session.get(Cargo.class, id);
            return cargo;
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Cargo> findAll() throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            @SuppressWarnings("unchecked")
            List<Cargo> cargos = session.createQuery("from Cargo cargo")
                    .list();
            return cargos;
        } catch (HibernateException e) {
            throw e;
        }
    }

    @Override
    public List<Cargo> findAllByNome(String nomeCargo) throws Exception {
        Session session = sessionFactory.getCurrentSession();

        try {
            Criteria criteria = session.createCriteria(Cargo.class);
            criteria.add(Restrictions.ilike("nome", "%" + nomeCargo + "%"));

            @SuppressWarnings("unchecked")
            List<Cargo> cargos = criteria.list();

            return cargos;
        } catch (HibernateException e) {
            throw e;
        }
    }

}
