package fr.utbm.info.da53.lw2.threeaddresscode;

import java.util.Objects;

public class ThreeAddressRecord {

    private ThreeAddressInstruction instruction;
    private String parameter1, parameter2;
    private String result;
    private String label;
    private String comment;

    public ThreeAddressRecord(ThreeAddressInstruction instruction, String parameter1, String parameter2, String result, String label, String comment) {
        this.instruction = instruction;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = result;
        this.label = label;
        this.comment = comment;
    }

    public ThreeAddressRecord(ThreeAddressInstruction instruction, String parameter1, String parameter2, String result) {
        this.instruction = instruction;
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = result;
        this.label = null;
        this.comment = null;
    }

    public ThreeAddressRecord(ThreeAddressInstruction instruction, String parameter1, String result) {
        this.instruction = instruction;
        this.parameter1 = parameter1;
        this.parameter2 = null;
        this.result = result;
        this.label = null;
        this.comment = null;
    }


    public ThreeAddressRecord(){

    }

    public ThreeAddressInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(ThreeAddressInstruction instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("Instruction cannot be null.");
        }
        this.instruction = instruction;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        if (parameter1 == null) {
            throw new IllegalArgumentException("Parameter 1 cannot be null.");
        }
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        if (result == null) {
            throw new IllegalArgumentException("Result cannot be null.");
        }
        this.result = result;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ThreeAddressRecord{" +
                "instruction=" + instruction +
                ", parameter1='" + parameter1 + '\'' +
                ", parameter2='" + parameter2 + '\'' +
                ", result='" + result + '\'' +
                ", label='" + label + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreeAddressRecord that = (ThreeAddressRecord) o;
        return instruction == that.instruction &&
                Objects.equals(parameter1, that.parameter1) &&
                Objects.equals(parameter2, that.parameter2) &&
                Objects.equals(result, that.result) &&
                Objects.equals(label, that.label) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instruction, parameter1, parameter2, result, label, comment);
    }
}
