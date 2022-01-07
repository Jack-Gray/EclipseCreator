package com.example.eclipsecreator;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OriginPackage {
    private final String name;
    private String description;
    protected final String contentRoot = "src/main/resources/com/example/eclipsecreator/";

    public OriginPackage(String name, String type) throws FileNotFoundException {
        this.name = name;
        if (type.equals("race")) {
            FileReader reader = new FileReader(contentRoot + "raceData.json");
            JSONObject originObject = new JSONObject(new JSONTokener(new BufferedReader(reader)));
            this.description = originObject.getString(name);
        } else {
            this.description = "";
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }
}
