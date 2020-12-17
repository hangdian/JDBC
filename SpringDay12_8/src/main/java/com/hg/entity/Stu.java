package com.hg.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    private String [] course;
    private List<String> list;
    private Map<String,String>maps;
    private Set<String> sets;

    public Stu() {
    }

    public Stu(String[] course, List<String> list, Map<String, String> maps, Set<String> sets) {
        this.course = course;
        this.list = list;
        this.maps = maps;
        this.sets = sets;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }



}
