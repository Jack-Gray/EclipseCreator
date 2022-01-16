package com.example.eclipsecreator;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Map;

public class SkillCellFactory extends TableCell<Skill, Map<String, Object>> {

    @Override
    protected void updateItem(Map<String, Object> item, boolean empty){
        super.updateItem(item, empty);

        if(empty || item == null){
            setText(null);
            setGraphic(null);
        } else {
            SkillType skillType = (SkillType) item.get("type");
            //noinspection unchecked
            ArrayList<String> option = (ArrayList<String>) item.get("option");
            String prefix = (String) item.get("prefix");
            switch (skillType) {
                case SINGLE -> {
                    setGraphic(null);
                    setText(option.get(0));
                }
                case DOUBLE -> {
                    setText(null);
                    ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(option));
                    comboBox.getSelectionModel().selectFirst();
                    setGraphic(comboBox);
                }
                case MULTI -> {
                    setText(null);
                    Label label = new Label(prefix + ": ");
                    ComboBox<String> comboBox = new ComboBox<>(FXCollections.observableArrayList(option));
                    comboBox.getSelectionModel().selectFirst();
                    HBox hBox = new HBox();
                    hBox.getChildren().addAll(label, comboBox);
                    hBox.setAlignment(Pos.CENTER_LEFT);
                    setGraphic(hBox);
                }
                case INPUT -> {
                    setText(null);
                    TextField textField = new TextField("Choose One:");
                    setGraphic(textField);
                }
            }
        }
    }
}
