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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dustin Wells
 */
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_LANGUAGES", joinColumns = {
        @JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "language_id")})
    private Set<Language> languages;
    @ManyToMany
    @JoinTable(name = "USER_SKILLS", joinColumns = {
        @JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "skill_id")})
    private Set<Skill> skills;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Job> jobHistory;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Education> educationHistory;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Certification> certificationHistory;

    public User() {
        this(null, "", "", "", "", "", new HashSet<Language>(), new HashSet<Skill>(), new HashSet<Job>(), new HashSet<Education>(), new HashSet<Certification>());
    }

    public User(Long id) {
        this(id, "", "", "", "", "", new HashSet<Language>(), new HashSet<Skill>(), new HashSet<Job>(), new HashSet<Education>(), new HashSet<Certification>());
    }

    public User(Long id, String name, String city, String state, String email, String phone, Set<Language> languages, Set<Skill> skills, Set<Job> jobs, Set<Education> ed, Set<Certification> certs) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.email = email;
        this.languages = languages;
        this.skills = skills;
        this.jobHistory = jobs;
        this.educationHistory = ed;
        this.certificationHistory = certs;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the languages
     */
    public Set<Language> getLanguages() {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    /**
     * @return the skills
     */
    public Set<Skill> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return the jobHistory
     */
    public Set<Job> getJobHistory() {
        return jobHistory;
    }

    /**
     * @param jobHistory the jobHistory to set
     */
    public void setJobHistory(Set<Job> jobHistory) {
        this.jobHistory = jobHistory;
    }

    /**
     * @return the educationHistory
     */
    public Set<Education> getEducationHistory() {
        return educationHistory;
    }

    /**
     * @param educationHistory the educationHistory to set
     */
    public void setEducationHistory(Set<Education> educationHistory) {
        this.educationHistory = educationHistory;
    }

    /**
     * @return the certificationHistory
     */
    public Set<Certification> getCertificationHistory() {
        return certificationHistory;
    }

    /**
     * @param certificationHistory the certificationHistory to set
     */
    public void setCertificationHistory(Set<Certification> certificationHistory) {
        this.certificationHistory = certificationHistory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
