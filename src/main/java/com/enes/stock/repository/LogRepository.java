package com.enes.stock.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enes.stock.model.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

	@Query("delete from logs where created_at between ?1 and ?2")
    Boolean deleteLogBetweenTwoDate(@Param("keyword") LocalDateTime date1, @Param("keyword2") LocalDateTime date2);
}
