package org.bevilacqua1996.output.impl;

import org.bevilacqua1996.output.OutputScores;

import java.util.logging.Logger;

public class OutputLog implements OutputScores {

    private static final Logger logger = Logger.getLogger(String.valueOf(OutputLog.class));
    @Override
    public void print(String printableMessage) {
        logger.info(printableMessage);
    }
}
