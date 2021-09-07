package com.fundamentosplatzi.springboot.fundamentosplatzi.controller;

import com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse.CreateUser;
import com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse.DeleteUser;
import com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentosplatzi.caseuse.UpdateUser;
import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import com.fundamentosplatzi.springboot.fundamentosplatzi.repository.UserRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    private UserRepository userRepository;
    @Autowired
    public UserRestController(GetUser getUser,CreateUser createUser,DeleteUser deleteUser,UpdateUser updateUser,UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;
        this.userRepository=userRepository;
    }

    //Create
    @PostMapping(value = "/create")
    public ResponseEntity<User> create(@RequestBody User user ){
        return ResponseEntity.ok(this.createUser.createUser(user));
    }

    //get
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id ){
        this.deleteUser.deleteUser(id);
        return ResponseEntity.ok("Deleted");
    }

    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id ,@RequestBody User user){
        this.updateUser.updateUser(id,user);
        return ResponseEntity.ok("Updated");
    }

    //Paging
    @GetMapping("/pageable")
    public List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }

}
