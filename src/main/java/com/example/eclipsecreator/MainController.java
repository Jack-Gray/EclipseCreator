package com.example.eclipsecreator;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private ToggleGroup race_toggleGroup;
    @FXML
    private ToggleGroup background_toggleGroup;
    @FXML
    private ToggleGroup career_toggleGroup;
    @FXML
    private ToggleGroup interest_toggleGroup;
    @FXML
    private RadioToggleButton anisaeva_button;
    @FXML
    private RadioToggleButton bilago_button;
    @FXML
    private RadioToggleButton callihara_button;
    @FXML
    private RadioToggleButton colonist_button;
    @FXML
    private RadioToggleButton kellek_button;
    @FXML
    private RadioToggleButton djek_button;
    @FXML
    private RadioToggleButton exith_button;
    @FXML
    private RadioToggleButton naora_button;
    @FXML
    private RadioToggleButton okex_button;
    @FXML
    private RadioToggleButton sekkess_button;
    @FXML
    private RadioToggleButton senn_button;
    @FXML
    private RadioToggleButton construct_button;
    @FXML
    private RadioToggleButton freelancer_button;
    @FXML
    private RadioToggleButton hyperelite_button;
    @FXML
    private RadioToggleButton indenture_button;
    @FXML
    private RadioToggleButton loner_button;
    @FXML
    private RadioToggleButton settler_button;
    @FXML
    private RadioToggleButton sheltered_button;
    @FXML
    private RadioToggleButton underclass_button;
    @FXML
    private RadioToggleButton freak_button;
    @FXML
    private RadioToggleButton psionicist_button;
    @FXML
    private RadioToggleButton academic_button;
    @FXML
    private RadioToggleButton covertOps_button;
    @FXML
    private RadioToggleButton enforcer_button;
    @FXML
    private RadioToggleButton explorer_button;
    @FXML
    private RadioToggleButton face_button;
    @FXML
    private RadioToggleButton genehacker_button;
    @FXML
    private RadioToggleButton hacker_button;
    @FXML
    private RadioToggleButton investigator_button;
    @FXML
    private RadioToggleButton medic_button;
    @FXML
    private RadioToggleButton mindhacker_button;
    @FXML
    private RadioToggleButton scavenger_button;
    @FXML
    private RadioToggleButton scientist_button;
    @FXML
    private RadioToggleButton soldier_button;
    @FXML
    private RadioToggleButton technologist_button;
    @FXML
    private RadioToggleButton artistIcon_button;
    @FXML
    private RadioToggleButton fighter_button;
    @FXML
    private RadioToggleButton firstAider_button;
    @FXML
    private RadioToggleButton forensics_button;
    @FXML
    private RadioToggleButton networker_button;
    @FXML
    private RadioToggleButton remoteOps_button;
    @FXML
    private RadioToggleButton student_button;
    @FXML
    private RadioToggleButton handler_button;
    @FXML
    private RadioToggleButton pantologist_button;
    @FXML
    private RadioToggleButton reprobate_button;
    @FXML
    private RadioToggleButton survivalist_button;
    @FXML
    private RadioToggleButton leader_button;
    @FXML
    private RadioToggleButton pilot_button;
    @FXML
    private RadioToggleButton slacker_button;
    @FXML
    private RadioToggleButton voyager_button;
    @FXML
    private RadioToggleButton psionics_button;
    @FXML
    private TextArea race_desc;
    @FXML
    private TextArea background_desc;
    @FXML
    private TextArea career_desc;
    @FXML
    private TextArea interest_desc;
    @FXML
    private TableView<Skill> background_table;
    @FXML
    private TableView<Skill> career_table;
    @FXML
    private TableView<Skill> interest_table;
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
}