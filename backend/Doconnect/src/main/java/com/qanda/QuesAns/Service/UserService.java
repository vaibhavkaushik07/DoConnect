package com.qanda.QuesAns.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.qanda.QuesAns.Repository.UserRepository;
import com.qanda.QuesAns.model.User;

import javax.persistence.Id;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean isExists(String email, String password) {
        return userRepository.findByPassword(password) != null && userRepository.findByEmail(email) != null;
    }

    public void save(User u) {
        userRepository.save(u);
    }

    public void delete(String email) {
        User u = userRepository.findByEmail(email);
        userRepository.delete(u);
    }

    public void update(User u) {
        userRepository.save(u);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    public List<String> getByDistinct(String name) {
        return userRepository.getByUniqueUser(name);
    }

}
