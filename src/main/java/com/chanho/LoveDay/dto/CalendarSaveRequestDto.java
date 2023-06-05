package com.chanho.LoveDay.dto;

import com.chanho.LoveDay.domain.Calendar;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CalendarSaveRequestDto {
    private String specialDate;
    private String content;
    private String writer;

    @Builder public CalendarSaveRequestDto(String specialDate, String content, String writer) {
        this.specialDate = specialDate;
        this.content = content;
        this.writer = writer;
    }

    public Calendar toEntity() {
        return Calendar.builder().specialDate(specialDate).content(content).writer(writer).build();
    }
}

