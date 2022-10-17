package com.mycloud.resttemplatedemo.repository;/*
 *
 * @author Lawshiga
 *
 */

import com.mycloud.resttemplatedemo.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
}
