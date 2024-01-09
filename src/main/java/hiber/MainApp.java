package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.createUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.createUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.createUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("Mazda", 3)));
      userService.createUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("bmw", 7)));

      List<User> users = userService.getAllUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println(user.getCar().toString());
         }
      }

      List<User> userWithCar = userService.getUsersByCar("bmw", 7);
      for (User user : userWithCar) {
         System.out.println(user.toString());
      }

      context.close();
   }
}
