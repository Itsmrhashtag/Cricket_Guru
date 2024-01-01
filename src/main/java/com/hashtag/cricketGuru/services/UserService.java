package com.hashtag.cricketGuru.services;





import com.hashtag.cricketGuru.model.User;
import com.hashtag.cricketGuru.model.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public  void deleteUser(Long userId);
}
