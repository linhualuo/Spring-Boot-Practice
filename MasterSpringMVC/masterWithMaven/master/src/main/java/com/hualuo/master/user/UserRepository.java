package com.hualuo.master.user;

import com.hualuo.master.error.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Joseph
 * @create 2017/11/26 21:48
 */
@Repository
public class UserRepository {

    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public User update(String email, User user) throws EntityNotFoundException {
        if (!exists(email)) {
            throw new EntityNotFoundException("User with email: " + email + " cannot be found.");
        }
        user.setEmail(email);
        return userMap.put(email, user);
    }

    public User save(User user) {
        return userMap.put(user.getEmail(), user);
    }

    public User findOne(String email) throws EntityNotFoundException {
        if (!exists(email)) {
            throw new EntityNotFoundException("User with email: " + email + " cannot be found.");
        }
        return userMap.get(email);
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public void delete(String email) throws EntityNotFoundException {
        if (!exists(email)) {
            throw new EntityNotFoundException("User with email: " + email + " cannot be found.");
        }
        userMap.remove(email);
    }

    public boolean exists(String email) {
        return userMap.containsKey(email);
    }
}
