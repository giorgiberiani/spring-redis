package com.springbootaplication.demo;



import java.util.List;
import java.util.Map;

public interface UserRepository {

   User findUser(User user);
   void save(User user);

}
