package Java.service;

import Java.model.Role;

import java.util.List;

public interface RoleService {
    public Role getById(int id);

    void saveRole(Role role);

    public Role getRoleByName(String name);

    public List<Role> getRoles();
}
