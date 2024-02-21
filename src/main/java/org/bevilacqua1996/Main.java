package org.bevilacqua1996;

import org.bevilacqua1996.input.InputData;
import org.bevilacqua1996.input.impl.SimpleInputString;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        InputData inputData = new SimpleInputString();

        inputData.process("ABABABBAAA");
    }
}