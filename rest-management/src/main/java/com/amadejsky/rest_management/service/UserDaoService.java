package com.amadejsky.rest_management.service;

import com.amadejsky.rest_management.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static int usersCount = 4;
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"Neo", LocalDate.now().minusYears(32)));
        users.add(new User(2,"Trinity", LocalDate.now().minusYears(30)));
        users.add(new User(3,"Morpheus", LocalDate.now().minusYears(40)));
        users.add(new User(4,"Smith", LocalDate.now().minusYears(35)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        for(User u: users){
            if(u.getId()==id)
                return u;
        }
//        throw new IllegalArgumentException("User with given Id "+id+" does't exist");
        return null;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

//    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
//    }
}
