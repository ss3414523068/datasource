package com.demo.repository;

import com.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user(name,password) VALUES(?1,?2)", nativeQuery = true)
    int customInsert(String name, String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET name=?2,password=?3 WHERE id=?1", nativeQuery = true)
    int customUpdate(Long id, String name, String password);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user WHERE id=?1", nativeQuery = true)
    int customDelete(Long id);

    @Query(value = "SELECT * FROM user WHERE name = ?1 AND password = ?2", nativeQuery = true)
    List<User> customList(String name, String pwd);

}
