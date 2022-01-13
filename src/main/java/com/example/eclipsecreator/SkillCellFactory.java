package com.example.eclipsecreator;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class SkillCellFactory extends TableCell<Skill, ArrayList<String>> {
    private final ArrayList<Skill> skills;

    public SkillCellFactory(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    @Override
    protected void updateItem(ArrayList<String> item, boolean empty){
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);
            setGraphic(null);
            if(item.size() > 1){
                HBox hBox = new HBox();
                Label label = new Label();
                ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(item));
                skills.stream().filter(o -> o.getOption().equals(item)).findFirst().ifPresent(skill -> label.setText(skill.getPrefix() + ": "));
                hBox.getChildren().addAll(label, comboBox);
                label.setMaxHeight(400);
                label.setCenterShape(true);
                setGraphic(hBox);
            } else {
                setText(item.toString());
            }
        }
    }
}
