package com.example.eclipsecreator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkillPackage extends OriginPackage {
    private final ArrayList<Skill> skillList;

    public SkillPackage(String name, String type) throws IOException {
        super(name, type);
        FileReader reader = new FileReader(contentRoot + String.format("%sData.json", type));
        JSONObject originObject = new JSONObject(new JSONTokener(new BufferedReader(reader))).getJSONObject(name);
        reader.close();
        this.setDescription(originObject.getString("description"));
        JSONArray originArray = originObject.getJSONArray("skills");
        this.skillList = createSkillList(originArray);
    }

    private ArrayList<Skill> createSkillList(JSONArray array) {
        ArrayList<Skill> skillArrayList = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            String type = object.getString("type");
            Skill skill = new Skill(type);
            if (type.equals("SINGLE")) {
                ArrayList<String> option = new ArrayList<>(List.of(object.getString("option")));
                Integer value = object.getInt("value");
                skill.setOption(option);
                skill.setValue(value);
            } else if (type.equals("DOUBLE") || type.equals("MULTI")) {
                JSONArray jsonArray = object.getJSONArray("option");
                ArrayList<String> option = new ArrayList<>();
                for (int j = 0; j < jsonArray.length(); j++) {
                    option.add(jsonArray.getString(j));
                }
                Integer value = object.getInt("value");
                if (type.equals("MULTI")) {
                    String prefix = object.getString("prefix");
                    skill.setPrefix(prefix);
                }
                skill.setOption(option);
                skill.setValue(value);
            } else {
                Integer value = object.getInt("value");
                skill.setValue(value);
            }
            skillArrayList.add(skill);
        }
        return skillArrayList;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }
}
