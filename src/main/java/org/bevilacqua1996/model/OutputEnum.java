package org.bevilacqua1996.model;

import org.bevilacqua1996.output.OutputScores;
import org.bevilacqua1996.output.impl.OutputSysout;

public enum OutputEnum {
    OUTPUT_SYSOUT("OutputSysout", new OutputSysout());

    private final String output;
    private final OutputScores classOutput;

    OutputEnum(String output, OutputScores classOutput) {
        this.output = output;
        this.classOutput = classOutput;
    }

    public String getOutput() {
        return output;
    }

    public static OutputScores ofOutputString(String output) {
        for(OutputEnum outputEnum : OutputEnum.values()) {
            if(outputEnum.getOutput().equals(output)) {
                return outputEnum.classOutput;
            }
        }
        throw new RuntimeException( "Print Mode not found: " + output);
    }
}
