package fr.utbm.info.da53.lw2.threeaddresscode;

import java.util.ArrayList;

public class ThreeAddressCode {

    private ArrayList<ThreeAddressRecord> code;

    public ThreeAddressCode() {
        this.code = new ArrayList<>();
    }

    public void addRecord(ThreeAddressRecord record) {
        this.code.add(record);
    }

    public ArrayList<ThreeAddressRecord> getCode() {
        return code;
    }

    public void setCode(ArrayList<ThreeAddressRecord> code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "ThreeAddressCode{" +
                "code=" + code +
                '}';
    }
}
