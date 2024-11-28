package com.aplose.digihello.dto;

public class DepartmentDto {
    private String departmentCode;
    private String departmentName;
    private Long inhabitantsNb;

    /**
     * Getter
     *
     * @return departmentCode
     **/
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * Setter
     *
     * @param : departmentCode
     **/
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * Getter
     *
     * @return departmentName
     **/
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Setter
     *
     * @param : departmentName
     **/
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Getter
     *
     * @return inhabitantsNb
     **/
    public Long getInhabitantsNb() {
        return inhabitantsNb;
    }

    /**
     * Setter
     *
     * @param : inhabitantsNb
     **/
    public void setInhabitantsNb(Long inhabitantsNb) {
        this.inhabitantsNb = inhabitantsNb;
    }
}
