package ua.org.smit.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import ua.org.smit.model.BlogEntity;




@Service
public class Dao implements DaoInterface<BlogEntity, String> {

    private final HibernateSession session = new HibernateSession();

    @Override
    public int write(BlogEntity entity) {
        session.openCurrentSessionwithTransaction();
        session.getCurrentSession().save(entity);
        session.closeCurrentSessionwithTransaction();
        return entity.getId();
    }

    @Override
    public void update(BlogEntity entity) {
        session.openCurrentSessionwithTransaction();
        session.getCurrentSession().update(entity);
        session.closeCurrentSessionwithTransaction();
    }

    @Override
    public BlogEntity getById(int id) {
        session.openCurrentSession();
        BlogEntity entity = (BlogEntity) session.getCurrentSession().get(BlogEntity.class, id);
        session.closeCurrentSession();
        return entity; 
    }

    @Override
    public void delete(BlogEntity entity) {
        session.openCurrentSessionwithTransaction();
        session.getCurrentSession().delete(entity);
        session.closeCurrentSessionwithTransaction();
    }

    @Override
    public List<BlogEntity> getAll() {
        session.openCurrentSession();
        List<BlogEntity> users = (List<BlogEntity>) session.getCurrentSession().createQuery("from BlogEntity").list(); 
        session.closeCurrentSession();
        return users;
    }

    @Override
    public List<BlogEntity> findAll(String search) {
        session.openCurrentSession();
        Query query = session.getCurrentSession().createQuery("from BlogEntity where title like :value ");
        query.setParameter("value", "%" + search + "%");
        List<BlogEntity> users = (List<BlogEntity>) query.list();
        session.closeCurrentSession();
        return users;
    }


   

}
