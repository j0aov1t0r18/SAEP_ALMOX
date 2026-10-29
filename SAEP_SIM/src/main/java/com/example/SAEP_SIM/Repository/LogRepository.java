package com.example.SAEP_SIM.Repository;

import com.example.SAEP_SIM.Model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    Optional<Log> findById (Long idLog);
}
