package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void createUser(User user);
   List<User> getAllUsers();
   public List<User> getUsersByCar(String model, int series);
}
