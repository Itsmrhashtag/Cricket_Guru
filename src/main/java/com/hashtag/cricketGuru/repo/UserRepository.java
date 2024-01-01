package com.hashtag.cricketGuru.repo;




import com.hashtag.cricketGuru.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);
}
