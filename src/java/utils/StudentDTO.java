/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StudentDTO implements Serializable{
    private String name;
    private String yob;
    private String gender;
    private List<Course> courses;

    public StudentDTO() {
    }

    
    public StudentDTO(String name, String yob, String gender, List<Course> courses) {
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course){
        if(courses == null)
            courses = new ArrayList();
        courses.add(course);
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "name=" + name + ", yob=" + yob + ", gender=" + gender + ", courses=" + courses + '}';
    }
    
}
