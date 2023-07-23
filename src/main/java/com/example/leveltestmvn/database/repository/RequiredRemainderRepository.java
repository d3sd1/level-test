package com.example.leveltestmvn.database.repository;

import com.example.leveltestmvn.database.model.RequiredRemainder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequiredRemainderRepository extends JpaRepository<RequiredRemainder, Long> {
    Optional<RequiredRemainder> findByXAndYAndN(int x, int y, int n);
}
