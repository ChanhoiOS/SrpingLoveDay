package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CalendarDeleteRequestDto {
    private String specialDate;
    private String writer;

    @Builder public CalendarDeleteRequestDto(String specialDate, String writer) {
        this.specialDate = specialDate;
        this.writer = writer;
    }

    public Calendar toEntity() {
        return Calendar.builder().specialDate(specialDate).writer(writer).build();
    }
}