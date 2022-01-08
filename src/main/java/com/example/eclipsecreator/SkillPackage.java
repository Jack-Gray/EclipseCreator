package com.example.eclipsecreator;

import java.util.ArrayList;

public class SkillPackage extends OriginPackage {
    private final ArrayList<Skill> skillList;

    public SkillPackage(String name, String description, ArrayList<Skill> skillList) {
        super(name, description);
        this.skillList = skillList;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }
}
