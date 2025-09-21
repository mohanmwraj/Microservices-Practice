package com.mohan.restful_web_service.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
        users.add(new User(4, "Jesus", LocalDate.now().minusYears(15)));
        users.add(new User(5, "Venky", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return users.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }
}
