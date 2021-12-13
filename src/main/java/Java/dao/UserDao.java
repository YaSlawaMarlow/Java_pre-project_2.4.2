package Java.dao;

import Java.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User getUser(int id);

    public User getUserByName(String name);
}