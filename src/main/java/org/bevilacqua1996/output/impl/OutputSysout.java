package org.bevilacqua1996.output.impl;

import org.bevilacqua1996.output.OutputScores;

public class OutputSysout implements OutputScores {
    @Override
    public void print(String printableMessage) {
        System.out.println(printableMessage);
    }
}
