package com.example.eclipsecreator;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class SkillPackageTest {
    SkillPackage skillPackageOne;
    SkillPackage skillPackageTwo;

    @BeforeEach
    void setUp() throws IOException {
        File outputFile = new File("src/main/resources/com/example/eclipsecreator/testData.json");
        File testFile = new File("src/test/resources/testData.json");
        FileWriter writer = new FileWriter(outputFile);
        JSONObject ob = new JSONObject(new JSONTokener(new FileReader(testFile)));
        ob.write(writer);
        writer.close();
        skillPackageOne = new SkillPackage("packageOne", "test");
        skillPackageTwo = new SkillPackage("packageTwo", "test");
        if (outputFile.delete()){
            System.out.println("Test file deleted successfully");
        } else {
            System.out.println("Failed to delete test file");
        }
    }

    @Test
    void getName() {
        assertEquals("packageOne", skillPackageOne.getName());
        assertEquals("packageTwo", skillPackageTwo.getName());
    }

    @Test
    void getDescription() {
        assertEquals("This is a test.", skillPackageOne.getDescription());
        assertEquals("This is a test.", skillPackageTwo.getDescription());
    }

    @Test
    void setDescription() {
        skillPackageOne.setDescription("This is a different test");
        assertEquals("This is a different test", skillPackageOne.getDescription());
    }

    @Test
    void getSkillList() {
        ArrayList<Skill> skillArrayList = skillPackageOne.getSkillList();
        Integer skillArrayListSize = skillArrayList.size();
        assertEquals(4, skillArrayListSize, String.format("Expected skillArrayList size 4, got %d", skillArrayListSize));
        for(int i = 0; i < skillArrayListSize; i++){
            Skill skill = skillArrayList.get(i);
            if(i == 0){
                assertEquals("SINGLE", skill.getType());
                assertEquals("test", skill.getOption().get(0));
                assertEquals(50, skill.getValue());
            } else if (i == 1){
                assertEquals("DOUBLE", skill.getType());
                assertEquals("testTwo", skill.getOption().get(1));
                assertEquals(60, skill.getValue());
            } else if (i == 2){
                assertEquals("MULTI", skill.getType());
                assertEquals("test", skill.getPrefix());
                assertEquals("testThree", skill.getOption().get(2));
                assertEquals(70, skill.getValue());
            } else if (i == 3){
                assertEquals("INPUT", skill.getType());
                assertEquals(40, skill.getValue());
            }
        }
    }
}