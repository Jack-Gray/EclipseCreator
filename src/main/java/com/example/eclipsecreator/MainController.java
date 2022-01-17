package com.example.eclipsecreator;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static java.lang.Math.min;

public class MainController {
    private final PackageDao packageDao = new PackageDao();
    private final EclipseCharacter eclipseCharacter = new EclipseCharacter();
    private final Integer aptitudePointsMax = 60;
    private final IntegerProperty aptitudePointsRemaining = new SimpleIntegerProperty(aptitudePointsMax);

    @FXML
    private ToggleGroup container_toggleGroup;
    @FXML
    private VBox ego_container;
    @FXML
    private VBox skill_container;
    @FXML
    private ToggleGroup race_toggleGroup;
    @FXML
    private ToggleGroup background_toggleGroup;
    @FXML
    private ToggleGroup career_toggleGroup;
    @FXML
    private ToggleGroup interest_toggleGroup;
    @FXML
    private Text race_desc;
    @FXML
    private Text background_desc;
    @FXML
    private Text career_desc;
    @FXML
    private Text interest_desc;
    public TableView<Skill> background_table;
    public TableView<Skill> career_table;
    public TableView<Skill> interest_table;
    @FXML
    private TextField name_field;
    @FXML
    private TextField genderID_field;
    @FXML
    private TextField age_field;
    @FXML
    private TextField background_field;
    @FXML
    private TextField career_field;
    @FXML
    private TextField interest_field;
    @FXML
    private TextField faction_field;
    @FXML
    private TextField race_field;
    @FXML
    private TextField cp_field;
    @FXML
    private TextField motivation1_field;
    @FXML
    private TextField motivation2_field;
    @FXML
    private TextField motivation3_field;
    @FXML
    private Spinner<Integer> cognition_spinner;
    @FXML
    private Spinner<Integer> intuition_spinner;
    @FXML
    private Spinner<Integer> reflexes_spinner;
    @FXML
    private Spinner<Integer> savvy_spinner;
    @FXML
    private Spinner<Integer> somatics_spinner;
    @FXML
    private Spinner<Integer> willpower_spinner;
    @FXML
    private Label aptitudeRemaining_label;
    @FXML
    private Label traumaThreshold_label;
    @FXML
    private Label lucidity_label;
    @FXML
    private Label insanityRating_label;
    @FXML
    private Label initiative_label;
    @FXML
    private Label basicPerception_label;
    @FXML
    private TableView<Skill> knowSkills_table;
    @FXML
    private Label knowRemaining_label;
    @FXML
    private TableView<Skill> activeSkills_table;
    @FXML
    private Label activeRemaining_label;

    @FXML
    protected void initialize(){

        skill_container.setVisible(false);
        skill_container.setManaged(false);
        setInitialValues();

        race_toggleGroup.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioToggleButton radioToggleButton = (RadioToggleButton) race_toggleGroup.getSelectedToggle();
            setTabData(radioToggleButton.getText().toLowerCase(), "race");
        });

        background_toggleGroup.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioToggleButton radioToggleButton = (RadioToggleButton) background_toggleGroup.getSelectedToggle();
            setTabData(radioToggleButton.getText().toLowerCase(), "background");
        });

        career_toggleGroup.selectedToggleProperty().addListener(((observableValue, toggle, t1) -> {
            RadioToggleButton radioToggleButton = (RadioToggleButton) career_toggleGroup.getSelectedToggle();
            setTabData(radioToggleButton.getText().toLowerCase(), "career");
        }));

        interest_toggleGroup.selectedToggleProperty().addListener(((observableValue, toggle, t1) -> {
            RadioToggleButton radioToggleButton = (RadioToggleButton) interest_toggleGroup.getSelectedToggle();
            setTabData(radioToggleButton.getText().toLowerCase(), "interest");
        }));

        container_toggleGroup.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioToggleButton radioToggleButton = (RadioToggleButton) container_toggleGroup.getSelectedToggle();
            if(radioToggleButton.getText().equals("Ego")){
                skill_container.setVisible(false);
                skill_container.setManaged(false);
                ego_container.setVisible(true);
                ego_container.setManaged(true);
            } else {
                ego_container.setVisible(false);
                ego_container.setManaged(false);
                skill_container.setVisible(true);
                skill_container.setManaged(true);
            }
        });
    }

    private void setInitialValues(){
        setTabData("anisaeva", "race");
        setTabData("construct", "background");
        setTabData("academic", "career");
        setTabData("artist/icon", "interest");
        setSpinnerValueFactories();
    }

    private void setTabData(String name, String category){
        OriginPackage originPackage;
        if(category.equals("race")){
            originPackage = packageDao.findRacePackage(name);
        } else {
            originPackage = packageDao.findSkillPackage(name, category);
        }
        switch (category) {
            case "race" -> {
                race_field.setText(StringUtils.capitalize(originPackage.getName()));
                race_desc.setText(originPackage.getDescription());
                eclipseCharacter.setRace(originPackage);
            }
            case "background" -> {
                background_field.setText(StringUtils.capitalize(originPackage.getName()));
                background_desc.setText(originPackage.getDescription());
                setTableData(background_table, ((SkillPackage) originPackage).getSkillList());
                eclipseCharacter.setBackground((SkillPackage) originPackage);
            }
            case "career" -> {
                career_field.setText(StringUtils.capitalize(originPackage.getName()));
                career_desc.setText(originPackage.getDescription());
                setTableData(career_table, ((SkillPackage) originPackage).getSkillList());
                eclipseCharacter.setCareer((SkillPackage) originPackage);
            }
            case "interest" -> {
                interest_field.setText(StringUtils.capitalize(originPackage.getName()));
                interest_desc.setText(originPackage.getDescription());
                setTableData(interest_table, ((SkillPackage) originPackage).getSkillList());
                eclipseCharacter.setInterest((SkillPackage) originPackage);
            }
        }
    }

    @SuppressWarnings("unchecked")
    //TODO: possibly convert tables to listviews with custom cells to avoid headers?
    private void setTableData(TableView<Skill> tableView, ArrayList<Skill> skills){
        tableView.getColumns().clear();
        ObservableList<Skill> tableSkills = FXCollections.observableArrayList(skills);
        tableView.setItems(tableSkills);
        TableColumn<Skill, Map<String, Object>> option = new TableColumn<>("Skill");
        TableColumn<Skill, Integer> value = new TableColumn<>("Value");
        option.setCellValueFactory(skillListCellDataFeatures -> {
            Skill skill = skillListCellDataFeatures.getValue();
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("type", skill.getSkillType());
            objectMap.put("prefix", skill.getPrefix());
            objectMap.put("option", skill.getOption());
            return new ReadOnlyObjectWrapper<>(objectMap);
        });
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        option.setCellFactory(skillArrayListTableColumn -> new SkillCellFactory());
        tableView.getColumns().addAll(option, value);
    }

    private void setSpinnerValueFactories(){
        for(var spinner : Arrays.asList(cognition_spinner, intuition_spinner, reflexes_spinner, savvy_spinner, somatics_spinner, willpower_spinner)) {
            IntegerSpinnerValueFactory factory = new IntegerSpinnerValueFactory(5, aptitudePointsMax, 5);
            factory.maxProperty().bind(Bindings.createIntegerBinding(() -> min(aptitudePointsRemaining.get() + factory.getValue(), 30), aptitudePointsRemaining, factory.valueProperty()));

            factory.valueProperty().addListener((observable, oldValue, newValue) -> {
                aptitudePointsRemaining.set(aptitudePointsRemaining.get() + oldValue - newValue);
                aptitudeRemaining_label.setText("Points remaining: " + aptitudePointsRemaining.getValue().toString());
            });

            spinner.setValueFactory(factory);
            aptitudeRemaining_label.setText("Points remaining: " + aptitudePointsRemaining.getValue().toString());
        }
    }
}