package com.example.demo.repository;

import com.example.demo.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
//@Component
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    Boolean existsByAddress(String address);

    EmployeeEntity findByUserName(String username);

    //    select * from Employee u where u.lastname like '%min%'
//    @Query("select u from EmployeeEntity u where u.lastname like '%?1%' ")
//    List<EmployeeEntity> findByAddressContaining(String address);

    //    @Query("select u from EmployeeEntity u where u.address = ?1")
    List<EmployeeEntity> findByAddressLike(String address);

    @Query("SELECT e FROM EmployeeEntity e ORDER BY e.id DESC")
    List<EmployeeEntity> findAllByOrderByIdDesc();

    @Query("SELECT e FROM EmployeeEntity e ORDER BY e.lastname DESC")
    List<EmployeeEntity> finAllByOrderByNameDesc();

    @Query("select t from EmployeeEntity t where t.id = ?1")
    EmployeeEntity findByIdd(Long id);

    @Query("select t from EmployeeEntity t where t.userName = ?1 and t.password = ?2")
    EmployeeEntity findByUserNameAndPassword(String UserName,String Password);

}
