package org.genspark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address ad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPh() {
        return ph;
    }

    public void setPh(List<Phone> ph) {
        //if (this.getPh() == null) List<Phone> list = new ArrayList<>();
        this.ph = ph;
    }

    public Address getAd() {
        return ad;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }

    public Student() {
    }

    public Student(int id, String name, Phone ph, Address ad) {
        this.id = id;
        this.name = name;
        this.ph.add(ph);
        this.ad = ad;
    }

    @Override
    public String toString() {
        String text = "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=";
        Iterator<Phone> itr = ph.iterator();
        while (itr.hasNext()){
            text = text + itr.next() + ",";
        }
        text = text +
                " ad=" + ad +
                '}';
        return text;
    }
}
