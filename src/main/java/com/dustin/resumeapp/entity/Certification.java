/*
 * Copyright (C) 2018 Dustin Wells
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dustin.resumeapp.entity;

import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dustin Wells
 */
@Entity
@Table
public class Certification {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column
    private String name;
    @Column
    private Date dateAcquired;
    @Column
    private Date dateExpires;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private User user;

    public Certification() {
        this(null, "", null, null, null);
    }

    public Certification(Long id) {
        this(id, "", null, null, null);
    }

    public Certification(Long id, String name, Date start, Date end, User user) {
        this.id = id;
        this.name = name;
        this.dateAcquired = start;
        this.dateExpires = end;
        this.user = user;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateAcquired
     */
    public Date getDateAcquired() {
        return dateAcquired;
    }

    /**
     * @param dateAcquired the dateAcquired to set
     */
    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    /**
     * @return the dateExpires
     */
    public Date getDateExpires() {
        return dateExpires;
    }

    /**
     * @param dateExpires the dateExpires to set
     */
    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.dateAcquired);
        hash = 47 * hash + Objects.hashCode(this.dateExpires);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Certification other = (Certification) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateAcquired, other.dateAcquired)) {
            return false;
        }
        if (!Objects.equals(this.dateExpires, other.dateExpires)) {
            return false;
        }
        return true;
    }

}
