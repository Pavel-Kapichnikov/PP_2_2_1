package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
    List<User> getUsersByCar(String model, int series);
}
