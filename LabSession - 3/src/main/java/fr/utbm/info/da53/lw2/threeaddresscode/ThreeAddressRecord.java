package fr.utbm.info.da53.lw2.threeaddresscode;

public class ThreeAddressRecord {

    private ThreeAddressInstruction instruction;
    private String parameter;
    private String result;
    private String label;
    private String comment;

    public ThreeAddressRecord(ThreeAddressInstruction instruction, String parameter, String result, String label, String comment) {
        this.instruction = instruction;
        this.parameter = parameter;
        this.result = result;
        this.label = label;
        this.comment = comment;
    }

    public ThreeAddressRecord(){

    }

    public ThreeAddressInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(ThreeAddressInstruction instruction) {
        this.instruction = instruction;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
                ", parameter='" + parameter + '\'' +
                ", result='" + result + '\'' +
                ", label='" + label + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
