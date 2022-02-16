package edu.neu.csye6225.service.api;

import edu.neu.csye6225.dao.UserDao;
import edu.neu.csye6225.model.pojo.User;
import edu.neu.csye6225.util.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = ApiException.class)
    public User createUser(User user) throws ApiException {
        User userDB = userDao.getUserByUsername(user.getUsername());
        if(userDB!=null) {
            System.out.println("User already exists");
            throw new ApiException("User already exists");
        }
        return userDao.insertNewUser(user);
    }

    @Transactional(rollbackFor = ApiException.class)
    public void updateUser(User user) throws ApiException {
        User userDB = userDao.getUserByUsername(user.getUsername());
        if(userDB==null) {
            throw new ApiException("No user exists");
        }
//        if(!user.getUsername().equals(userDB.getUsername())) {
//            throw new ApiException("Username modification not allowed");
//        }
        userDB.setFirst_name(user.getFirst_name());
        userDB.setLast_name(user.getLast_name());
        userDB.setPassword(user.getPassword());
        userDao.updateUser(userDB);
    }

    @Transactional(readOnly = true)
    public User getUserDetails(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userCredentials = userDao.getUserByUsername(username); //database
        return new MyUserDetails(userCredentials);
    }
}
