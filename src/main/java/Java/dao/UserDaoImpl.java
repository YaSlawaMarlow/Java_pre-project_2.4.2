package Java.dao;

import Java.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.*;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }

    @Transactional (readOnly = true)
    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }
}
