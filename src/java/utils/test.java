///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package handler;
//
//import dtos.StudentDTO;
//import java.util.ArrayList;
//import java.util.List;
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
///**
// *
// * @author Admin
// */
//public class StudentStatusHandler extends DefaultHandler{
//    private String searchValue;
//    private String tagName;
//    private List<StudentDTO> students;
//    private StudentDTO student;
//    private boolean bFound;
//
//    public StudentStatusHandler() {
//        this.searchValue = "";
//        this.tagName = "";
//        this.bFound = false;
//    }
//
//    public StudentStatusHandler(String searchValue) {
//        this.searchValue = searchValue;
//        this.tagName = "";
//        this.bFound = false;
//    }
//
//    
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        this.tagName = qName;           
//        if(qName.equals("student")){
//            String id = attributes.getValue("id");
//            this.student = new StudentDTO();
//            student.setId(id);
//            String sClass = attributes.getValue("class");
//            student.setsClass(sClass);
//        }
//    }
//    
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if(qName.equals("student")){
//            if(this.bFound){
//                if(this.students==null){
//                    this.students = new ArrayList<StudentDTO>();
//                }
//                this.students.add(student);
//                this.student=null;
//            }
//            this.bFound = false;
//        }
//        this.tagName="";
//        System.out.println("b Found " + bFound);
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        String str = new String(ch, start, length);
//        if(this.tagName.equals("lastname")){
//            this.student.setLastname(str.trim());
//        }else if(this.tagName.equals("middlename")){
//            this.student.setMiddlename(str.trim());
//        }else if(this.tagName.equals("firstname")){
//            this.student.setFirstname(str.trim());
//        }else if(this.tagName.equals("sex")){
//            this.student.setSex(Integer.parseInt(str.trim()));
//        }else if(this.tagName.equals("password")){
//            this.student.setPassword(str.trim());
//        }else if(this.tagName.equals("address")){
//            this.student.setAddress(str.trim());
//        }else if(this.tagName.equals("status")){
//            this.student.setStatus(str.trim());
//            if(str.trim().contains(this.searchValue)){
//                this.bFound = true;
//            }
//        }
//    }
//
//    public List<StudentDTO> getStudents() {
//        return students;
//    }  
//    
//}