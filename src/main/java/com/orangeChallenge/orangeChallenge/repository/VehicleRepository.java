package com.orangeChallenge.orangeChallenge.repository;

import com.orangeChallenge.orangeChallenge.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
