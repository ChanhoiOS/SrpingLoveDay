package com.chanho.LoveDay.repository;

import com.chanho.LoveDay.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    List<Calendar> findAllByWriterIn(List<String> writers);
    List<Calendar> findAllByWriter(String writer);
    void deleteBySpecialDateAndWriter(String specialDate, String writer);

}

