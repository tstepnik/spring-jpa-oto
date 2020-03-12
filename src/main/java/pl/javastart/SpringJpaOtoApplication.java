package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.dao.UserDao;
import pl.javastart.dao.UserDetailsDao;
import pl.javastart.model.User;
import pl.javastart.model.UserDetails;

@SpringBootApplication
public class SpringJpaOtoApplication {

    public static void main(String[] args)  {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtoApplication.class, args);

        UserDao userDao = ctx.getBean(UserDao.class);

        User user = new User("johnny234", "strongPass", "johnny@gmail.com");
        userDao.save(user);

        UserDetails details = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setDetails(details);
        userDao.update(user);

        UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
        UserDetails getUserDetails = userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());
        ctx.close();

    }
}
