package com.fundamentosplatzi.springboot.fundamentosplatzi.service;

import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user ->LOG.info("User to insert: " + user))
                .forEach(userRepository::save);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long id, User newUser){
        userRepository
                .findById(id)
                .map(user->{
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    return userRepository.save(user);
                });
    }
}

