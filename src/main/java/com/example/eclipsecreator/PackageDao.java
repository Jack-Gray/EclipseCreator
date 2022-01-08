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
    private final ArrayList<OriginPackage> racePackages = new ArrayList<>();
    private final ArrayList<SkillPackage> skillPackages = new ArrayList<>();

    public PackageDao() {
    }

    public OriginPackage findRacePackage(String name) throws IOException {
        OriginPackage racePackage;
        OriginPackage foundPackage = findPackageWithName(racePackages, name);

        if (foundPackage != null){
            racePackage = foundPackage;
        } else {
            String fileName = contentRoot + "raceData.json";
            racePackage = getPackageFromFile(fileName, name);
            racePackages.add(racePackage);
        }

        return racePackage;
    }

    public SkillPackage findSkillPackage(String name, String category) throws IOException {
        SkillPackage skillPackage;
        OriginPackage foundPackage = findPackageWithName(skillPackages, name);

        if (foundPackage != null){
            skillPackage = (SkillPackage) foundPackage;
        } else {
            String fileName = contentRoot + String.format("%sData.json", category);
            skillPackage = (SkillPackage) getPackageFromFile(fileName, name);
            skillPackages.add(skillPackage);
        }
        
        return skillPackage;
    }

    private OriginPackage getPackageFromFile(String fileName, String name) throws IOException {
        FileReader reader = new FileReader(fileName);
        Object object = new JSONObject(new JSONTokener(new BufferedReader(reader))).get(name);
        reader.close();

        OriginPackage originPackage;
        assert(object instanceof String || object instanceof JSONObject);
        if(object instanceof String description){
            originPackage = new OriginPackage(name, description);
        } else {
            JSONObject jsonObject = (JSONObject) object;
            String description = jsonObject.getString("description");
            JSONArray jsonArray = jsonObject.getJSONArray("skills");
            ArrayList<Skill> skillArrayList = createSkillList(jsonArray);
            originPackage = new SkillPackage(name, description, skillArrayList);
        }
        return originPackage;
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

    private OriginPackage findPackageWithName(ArrayList<? extends OriginPackage> arrayList, String name){
        return arrayList.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }
}
