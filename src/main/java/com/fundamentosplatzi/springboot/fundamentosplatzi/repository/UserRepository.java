package com.fundamentosplatzi.springboot.fundamentosplatzi.repository;

import com.fundamentosplatzi.springboot.fundamentosplatzi.dto.UserDto;
import com.fundamentosplatzi.springboot.fundamentosplatzi.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email,String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name,String email);

    List<User> findByBirthDateBetween(LocalDate begin,LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);
    //Alternative to like without %%
    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.fundamentosplatzi.springboot.fundamentosplatzi.dto.UserDto(u.id,u.name,u.birthDate)"+
            "FROM User u "+
            "WHERE u.birthDate=:dateparam"+" and u.email=:emailparam")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("dateparam") LocalDate date,@Param("emailparam") String email);
}
