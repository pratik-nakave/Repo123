package edu.neu.csye6225.controller;

import edu.neu.csye6225.model.data.UserData;
import edu.neu.csye6225.model.form.UserForm;
import edu.neu.csye6225.service.UserDto;
import edu.neu.csye6225.util.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends AbstractController {

    @Autowired
    private UserDto userDto;

    @PostMapping(value = "/v1/user", consumes={"application/json"})
    @ResponseBody
    public UserData createNewUser(@RequestBody UserForm userForm) throws ApiException {
        UserData userData = userDto.createUser(userForm);
        return userData;
    }

    @PutMapping(value = "/v1/user/self", consumes={"application/json"})
    public ResponseEntity<String> updateUserDetails(@RequestBody UserForm userForm) throws ApiException {
        userDto.updateUser(userForm);
        return new ResponseEntity<>(null, getHeaders(), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/v1/user/self")
    @ResponseBody
    public UserData getUserDetails() {
        return userDto.getUserDetails();

    }
}
