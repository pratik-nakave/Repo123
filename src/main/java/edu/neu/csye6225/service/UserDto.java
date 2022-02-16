package edu.neu.csye6225.service;

import edu.neu.csye6225.model.pojo.User;
import edu.neu.csye6225.model.data.UserData;
import edu.neu.csye6225.model.form.UserForm;
import edu.neu.csye6225.service.api.MyUserDetails;
import edu.neu.csye6225.service.api.UserService;
import edu.neu.csye6225.service.helper.UserDtoHelper;
import edu.neu.csye6225.util.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

    @Autowired
    private UserService userApi;

    @Autowired
    private UserDtoHelper dtoHelper;

    @Autowired
    MyUserDetails userDetails;

    public UserData createUser(UserForm userForm) throws ApiException {
        // TODO Validations for userForm
        User user = dtoHelper.convertToUser(userForm);
        User newUser = userApi.createUser(user);
        return dtoHelper.convertToUserData(newUser);
    }

    public void updateUser(UserForm userForm) throws ApiException {
        // TODO Validations for userForm and username
        User user = dtoHelper.convertToUser(userForm);
        userApi.updateUser(user);
    }

    public UserData getUserDetails() {
        // TODO Validations for username
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User userDetails = userApi.getUserDetails(username);
        return dtoHelper.convertToUserData(userDetails);
    }
}
