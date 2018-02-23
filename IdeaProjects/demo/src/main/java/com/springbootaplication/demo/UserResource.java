package com.springbootaplication.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserResource {

    private UserRepository userRepository;
    HttpStatus httpStatus = null;


    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @RequestMapping(method = RequestMethod.POST,value = "/id={id}")
    public ResponseEntity<User> findUser(@RequestBody User user,
                                   @PathVariable(value = "id", required = false) Integer id){

            if(userRepository.findUser(user) != null && userRepository.findUser(user).getPassword().equals(user.getPassword())) {
               return new ResponseEntity<>(user,HttpStatus.OK);
            }
        return new ResponseEntity<>(httpStatus.UNAUTHORIZED);

    }

    @RequestMapping(method = RequestMethod.PUT, value ="/add")
    public ResponseEntity<User> add(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user,httpStatus.OK);
    }
}
