/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Administrator
 */
public class StudentHandler extends DefaultHandler {

    private StudentDTO student;
    private Course tmpCourse;
    private boolean foundNode;
    private boolean endNode;
    private String currentTag;
    private String searchValue;
    private List<StudentDTO> listStudent;

    public StudentHandler() {

    }

    public StudentHandler(String searchValue) {
        this.searchValue = searchValue;
        foundNode = false;
        endNode = false;
        currentTag = "";
    }

    public List<StudentDTO> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<StudentDTO> listStudent) {
        this.listStudent = listStudent;
    }

    public String getCurrentTag() {
        return currentTag;
    }

    public void setCurrentTag(String currentTag) {
        this.currentTag = currentTag;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentTag = qName;
        if (qName.equals("student")) {
            foundNode = true;
        }
        if (foundNode && qName.equals("course")) {
            tmpCourse = new Course();
            tmpCourse.setMark(Float.parseFloat(attributes.getValue("mark")));
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("student") && student != null) {
            if (listStudent == null) {
                listStudent = new ArrayList<>();
            }
            System.out.println("Name = " + student);
            //System.out.println(student);
            if (student.getName().toLowerCase().contains(searchValue)) {
                listStudent.add(student);
            }
            student = null;
            currentTag = "";
            foundNode = false;
        } else if (qName.equals("course")) {
            student.addCourse(tmpCourse);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (foundNode && !str.trim().isEmpty()) {
            if (student == null) {
                student = new StudentDTO();
            }
            if (currentTag.equals("name")) {
                student.setName(str.trim());
            } else if (currentTag.equals("gender")) {
                student.setGender(str.trim());
            } else if (currentTag.equals("yob")) {
                student.setYob(str.trim());
            } else if (currentTag.equals("course")) {
                //System.out.println(str);
                tmpCourse.setName(str.trim());
            }
            // System.out.println("Value = " + student);
        }
    }

}
