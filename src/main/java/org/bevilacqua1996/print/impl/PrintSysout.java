package org.bevilacqua1996.print.impl;

import org.bevilacqua1996.print.PrintScores;

public class PrintSysout implements PrintScores {
    @Override
    public void print(String printableMessage) {
        System.out.println(printableMessage);
    }
}
