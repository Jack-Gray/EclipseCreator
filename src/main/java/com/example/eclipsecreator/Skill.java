package com.example.eclipsecreator;

import java.util.ArrayList;

public class Skill {
    private final SkillType skillType;
    private String prefix;
    private ArrayList<String> option;
    private final Integer value;

    // constructor for Skills where type == SINGLE
    public Skill(SkillType skillType, ArrayList<String> option, Integer value) {
        this.skillType = skillType;
        this.option = option;
        this.value = value;
    }

    // constructor for Skills where type == DOUBLE or MULTI
    public Skill(SkillType skillType, String prefix, ArrayList<String> option, Integer value) {
        this.skillType = skillType;
        this.prefix = prefix;
        this.option = option;
        this.value = value;
    }

    // constructor for Skill where type == INPUT
    public Skill(SkillType skillType, Integer value) {
        this.skillType = skillType;
        this.value = value;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public String getPrefix() {
        return prefix;
    }

    public ArrayList<String> getOption() {
        return option;
    }

    public Integer getValue() {
        return value;
    }
}
