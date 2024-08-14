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
        users.add(new User(1L,"Neo", LocalDate.now().minusYears(32)));
        users.add(new User(2L,"Trinity", LocalDate.now().minusYears(30)));
        users.add(new User(3L,"Morpheus", LocalDate.now().minusYears(40)));
        users.add(new User(4L,"Smith", LocalDate.now().minusYears(35)));
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
        user.setId((long) ++usersCount);
        users.add(user);
        return user;
    }

    public User deleteUser(int id){
        for(User u: users){
            if(u.getId()==id)
                users.remove(id);
        }
//        throw new IllegalArgumentException("User with given Id "+id+" does't exist");
        return null;
    }

//    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
//    }
}
