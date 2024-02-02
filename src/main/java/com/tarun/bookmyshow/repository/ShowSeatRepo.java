package com.tarun.bookmyshow.repository;

import com.tarun.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat, Integer> {

    @Lock(value = LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findShowSeatByIdIn(List<Integer> showSeatIdList);
}
