package com.chanho.LoveDay.service;

import com.chanho.LoveDay.domain.Calendar;
import com.chanho.LoveDay.dto.CalendarSaveRequestDto;
import com.chanho.LoveDay.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public List<Calendar> findPostsByWriters(String writer, String partner) {
        return calendarRepository.findAllByWriterIn(List.of(writer, partner));
    }

    public List<Calendar> findPostsByWriter(String writer) {
        return calendarRepository.findAllByWriter(writer);
    }

    @Transactional
    public Long save(CalendarSaveRequestDto requestDto) {
        return  calendarRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public void deleteCalendarBySpecialDateAndWriter(String specialDate, String writer) {
        calendarRepository.deleteBySpecialDateAndWriter(specialDate, writer);
    }

}