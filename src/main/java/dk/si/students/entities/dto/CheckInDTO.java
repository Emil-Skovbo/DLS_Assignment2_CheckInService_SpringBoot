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
public class CheckInDTO {

    private Long id;
    private Date created;
    private String code;

    public CheckInDTO(Long id, Date created, String code) {
        this.id = id;
        this.created = created;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
