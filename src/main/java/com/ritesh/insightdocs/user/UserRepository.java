package com.ritesh.insightdocs.user;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, UUID> {
User findByEmail(String email);     // Spring reads the method name
                               // and generates: SELECT * FROM users WHERE email = ?

boolean existsByEmail(String email);   // SELECT COUNT(*) > 0 FROM users WHERE email = ?

User findByNickName(String nick);   
boolean existsByNickName(String nickName);
boolean existsByNumber(String number);
// SELECT * FROM users WHERE nick_name = ?
}