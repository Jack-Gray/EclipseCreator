package com.example.eclipsecreator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PackageDao {

    private final String contentRoot = "src/main/resources/com/example/eclipsecreator/";

    public PackageDao() {
    }

    OriginPackage findRacePackage(String name) throws IOException {
        OriginPackage racePackage;

        String fileName = contentRoot + "raceData.json";
        // retrieve description from raceData.json
        Object object = getDataFromFile(fileName, name);

        String description = (String) object;
        racePackage = new OriginPackage(name, description);
        return racePackage;
    }

    SkillPackage findSkillPackage(String name, String category) throws IOException {
        SkillPackage skillPackage;

        String fileName = contentRoot + String.format("%sData.json", category);
        Object object = getDataFromFile(fileName, name);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = jsonObject.getJSONArray("skills");

        String description = jsonObject.getString("description");
        ArrayList<Skill> skillArrayList = createSkillList(jsonArray);
        skillPackage = new SkillPackage(name, description, skillArrayList);
        return skillPackage;
    }

    private Object getDataFromFile(String fileName, String key) throws IOException {
        FileReader reader = new FileReader(fileName);
        Object object = new JSONObject(new JSONTokener(new BufferedReader(reader))).get(key);
        reader.close();
        return object;
    }

    private ArrayList<Skill> createSkillList(JSONArray jsonArray) {
        ArrayList<Skill> skillArrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Skill skill;
            SkillType skillType;
            String prefix;
            ArrayList<String> option;
            int value;

            String type = jsonObject.getString("type");
            skillType = SkillType.valueOf(type);

            prefix = jsonObject.getString("prefix");

            Object object = jsonObject.get("option");
            if (object != null) {
                option = new ArrayList<>();
                if (object instanceof String string) {
                    option.add(string);
                } else if (object instanceof JSONArray array) {
                    for (int j = 0; j < array.length(); j++) {
                        option.add(array.getString(j));
                    }
                }
            } else {
                option = null;
            }

            value = jsonObject.getInt("value");

            skill = switch (skillType) {
                case SINGLE, DOUBLE -> new Skill(skillType, option, value);
                case MULTI -> new Skill(skillType, prefix, option, value);
                case INPUT -> new Skill(skillType, value);
            };
            skillArrayList.add(skill);
        }
        return skillArrayList;
    }
}
