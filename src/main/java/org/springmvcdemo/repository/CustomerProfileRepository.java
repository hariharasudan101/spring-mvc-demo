package org.springmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springmvcdemo.entity.CustomerProfile;

@Repository("customerProfileRepository")
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Integer> {

}