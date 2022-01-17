package com.example.eclipsecreator;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class EclipseCharacter {
    SimpleObjectProperty<OriginPackage> race;
    SimpleObjectProperty<SkillPackage> background;
    SimpleObjectProperty<SkillPackage> career;
    SimpleObjectProperty<SkillPackage> interest;
    SimpleListProperty<Integer> aptitudes;

    public OriginPackage getRace() {
        return race.get();
    }

    public SimpleObjectProperty<OriginPackage> raceProperty() {
        return race;
    }

    public void setRace(OriginPackage race) {
        this.race.set(race);
    }

    public SkillPackage getBackground() {
        return background.get();
    }

    public SimpleObjectProperty<SkillPackage> backgroundProperty() {
        return background;
    }

    public void setBackground(SkillPackage background) {
        this.background.set(background);
    }

    public SkillPackage getCareer() {
        return career.get();
    }

    public SimpleObjectProperty<SkillPackage> careerProperty() {
        return career;
    }

    public void setCareer(SkillPackage career) {
        this.career.set(career);
    }

    public SkillPackage getInterest() {
        return interest.get();
    }

    public SimpleObjectProperty<SkillPackage> interestProperty() {
        return interest;
    }

    public void setInterest(SkillPackage interest) {
        this.interest.set(interest);
    }

    public ObservableList<Integer> getAptitudes() {
        return aptitudes.get();
    }

    public SimpleListProperty<Integer> aptitudesProperty() {
        return aptitudes;
    }

    public void setAptitudes(ObservableList<Integer> aptitudes) {
        this.aptitudes.set(aptitudes);
    }
}
