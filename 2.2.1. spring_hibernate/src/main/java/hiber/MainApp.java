package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Valera", "Tapok", "vv@v");
        Car car1 = new Car("valeraCar", 3);
        car1.setUser(user1);
        userService.add(user1);
        userService.addCar(car1);

        User user2 = new User("Gena", "Nenarkotorgovec", "hh@h");
        Car car2 = new Car("genaCar", 4);
        car2.setUser(user2);
        userService.add(user2);
        userService.addCar(car2);

        User user3 = new User("Fedor", "Tormoz", "kk@k");
        Car car3 = new Car("fedyaCar", 5);
        car3.setUser(user3);
        userService.add(user3);
        userService.addCar(car3);

        System.out.println(userService.listUsers());

        System.out.println(userService.getUserByCar("fedyaCar", 5));

        context.close();
    }
}
