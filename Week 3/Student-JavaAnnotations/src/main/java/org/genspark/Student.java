package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class Student {
    private int id;
    private String name;
    @Autowired
    private List<Phone> ph;
    @Autowired
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

    public Student(int id, String name, List<Phone> ph, Address ad) {
        this.id = id;
        this.name = name;
        this.ph = ph;
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

    public void details(){
        System.out.println("This is a student.");
    }
}
