package org.bevilacqua1996.model;

import org.bevilacqua1996.input.InputData;
import org.bevilacqua1996.input.impl.SimpleInputString;

public enum InputEnum {

    SIMPLE_INPUT_STRING("SimpleInputString", new SimpleInputString());

    InputEnum(String inputString, SimpleInputString inputData) {
        this.inputString = inputString;
        this.inputData = inputData;
    }

    private final String inputString;
    private final InputData inputData;

    public String getInputString() {
        return inputString;
    }

    public static InputData ofInputString(String inputString) {
        for(InputEnum inputEnum : InputEnum.values()) {
            if(inputEnum.getInputString().equals(inputString)) {
                return inputEnum.inputData;
            }
        }
        throw new RuntimeException( "Input Mode not found: " + inputString);
    }
}
