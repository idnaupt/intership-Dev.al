package org.example.model;

public class Student {
        private Integer id;
        private String email;
        private Integer mosha;
        private  String emri;
        private String mbiemri;

    public int getId() {
        return id;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public int getMosha() {
        return mosha;
    }
    public Student(Integer id, String emri, String mbiemri, int mosha) {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.mosha = mosha;
    }


    }

