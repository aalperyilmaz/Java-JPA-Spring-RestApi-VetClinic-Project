package com.works.restapix.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ScheduleCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Integer sid;

    private String id;
    private String title;
    private Boolean isAllDay;
    private String start;
    private String end;
    private String category;
    private String dueDateClass;
    private String color;
    private String bgColor;
    private String dragBgColor;
    private String borderColor;
    private String location;
    private String raw;
    private String state;
    private String calendarId;

}
