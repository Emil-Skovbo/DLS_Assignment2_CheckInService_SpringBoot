/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.si.students.entities.dto;

import java.util.Date;

/**
 *
 * @author Emil Svensmark
 */
public class LectureDTO {

    private Long id;
    private Date startTime;
    private String location;

    public LectureDTO(Long id, Date startTime, String location) {
        this.id = id;
        this.startTime = startTime;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
