package org.bevilacqua1996;

import org.bevilacqua1996.input.InputData;
import org.bevilacqua1996.model.InputEnum;
import org.bevilacqua1996.utils.PropertiesSingleton;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String input = PropertiesSingleton.getInstance().getProperty("architecture.input");
        InputData inputData = InputEnum.ofInputString(input);

        Arrays.stream(args).forEach(inputData::process);
    }
}