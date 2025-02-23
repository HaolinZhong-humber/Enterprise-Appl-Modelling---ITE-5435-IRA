package com.example.Haolin_COMP303_Assignment3.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "programs")
public class Program {
    @Id
    private String programCode;

    private String programName;
    private int duration;
    private BigDecimal fee;

    public Program() {}

    public Program(String programCode, String programName, int duration, BigDecimal fee) {
        this.programCode = programCode;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
