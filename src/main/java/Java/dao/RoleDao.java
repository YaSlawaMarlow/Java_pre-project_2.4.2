package Java.dao;

import Java.model.Role;

import java.util.List;

public interface RoleDao {
    public Role getById(int id);

    public void saveRole(Role role);

    public Role getRoleByName(String name);

    public List<Role> getRoles();
}