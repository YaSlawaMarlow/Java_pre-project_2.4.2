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

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        return em.createQuery("select u from User u where u.name=:name",
                User.class).setParameter("name", name).getSingleResult();
    }
}
