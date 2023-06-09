package com.chanho.LoveDay.controller;

import com.chanho.LoveDay.domain.Calendar;
import com.chanho.LoveDay.dto.CalendarDeleteRequestDto;
import com.chanho.LoveDay.dto.CalendarSaveRequestDto;
import com.chanho.LoveDay.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping("/api/calendar")
    public List<Calendar> findAll(@RequestParam("writer") String writer, @RequestParam("partner") Optional<String> partner) {
        if (partner.isPresent()) {
            return calendarService.findPostsByWriters(writer, partner.get());
        } else {
            return calendarService.findPostsByWriter(writer);
        }
    }

    @PostMapping("/api/calendar")
    public Long save(@RequestBody CalendarSaveRequestDto requestDto) {
        return calendarService.save(requestDto);
    }


    @DeleteMapping("/api/calendar")
    public ResponseEntity<String> deleteCalendar(@RequestBody CalendarDeleteRequestDto requestDto) {
        calendarService.deleteCalendarBySpecialDateAndWriter(requestDto.getSpecialDate(), requestDto.getWriter());
        return ResponseEntity.ok("Calendar deleted successfully");
    }
}