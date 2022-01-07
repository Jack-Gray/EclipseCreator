package com.example.eclipsecreator;

import java.util.ArrayList;

public class Skill {
    private final String type;
    private String prefix;
    private ArrayList<String> option;
    private Integer value;

    public Skill(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public ArrayList<String> getOption() {
        return option;
    }

    public void setOption(ArrayList<String> option) {
        this.option = option;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
