package Java.dao;

import Java.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getById(int id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select r from Role r where r.role=:role", Role.class).setParameter("role", name).getSingleResult();
    }
}
