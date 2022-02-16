package edu.neu.csye6225.dao;

import edu.neu.csye6225.model.pojo.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao extends AbstractDao<User> {

    @Transactional
    public User insertNewUser(User user){
        em().persist(user);
        em().flush();
        return user;
    }

    @Transactional
    public void updateUser(User user){
        em().merge(user);
        em().flush();
    }

    public User getUserByUsername(String username){
        String select_id = "Select u From User u where username=:username";
        TypedQuery<User> query = getQuery(select_id, User.class);
        query.setParameter("username", username);
        return getSingle(query);
    }
}
