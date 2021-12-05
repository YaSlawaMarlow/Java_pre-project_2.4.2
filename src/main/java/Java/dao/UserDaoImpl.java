package Java.dao;

import Java.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.*;

@Transactional
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

    @Transactional
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
//        em.remove(em.find(User.class, user.getId()));
        getEntityManager()
                .createQuery("DELETE FROM User WHERE id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }
}
