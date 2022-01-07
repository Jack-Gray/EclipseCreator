package com.example.eclipsecreator;

import javafx.scene.control.ToggleButton;

// RadioToggleButton takes functionality from RadioButton:
// Clicking on a selected RadioToggleButton in a ToggleGroup will have no effect (it cannot be unselected in this way)
public class RadioToggleButton extends ToggleButton {

    @Override
    public void fire() {
        if (getToggleGroup() == null || !isSelected()){
            super.fire();
        }
    }
}
