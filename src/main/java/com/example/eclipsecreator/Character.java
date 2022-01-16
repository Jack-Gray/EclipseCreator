package com.example.eclipsecreator;

public class Character {
    OriginPackage race;
    SkillPackage background;
    SkillPackage career;
    SkillPackage interest;

    public Character(OriginPackage race, SkillPackage background, SkillPackage career, SkillPackage interest) {
        this.race = race;
        this.background = background;
        this.career = career;
        this.interest = interest;
    }

    public OriginPackage getRace() {
        return race;
    }

    public void setRace(OriginPackage race) {
        this.race = race;
    }

    public SkillPackage getBackground() {
        return background;
    }

    public void setBackground(SkillPackage background) {
        this.background = background;
    }

    public SkillPackage getCareer() {
        return career;
    }

    public void setCareer(SkillPackage career) {
        this.career = career;
    }

    public SkillPackage getInterest() {
        return interest;
    }

    public void setInterest(SkillPackage interest) {
        this.interest = interest;
    }
}
