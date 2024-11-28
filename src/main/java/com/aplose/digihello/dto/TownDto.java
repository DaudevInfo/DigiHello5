package com.aplose.digihello.dto;

public class TownDto {
    private Long id;
    private String name;
    private String departmentCode;
    private String departmentName;
    private Integer inhabitantsNb;

    /**
     * Getter
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param : id
     **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param : name
     **/
    public void setName(String name) {
        this.name = name;
    }

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
    public Integer getInhabitantsNb() {
        return inhabitantsNb;
    }

    /**
     * Setter
     *
     * @param : inhabitantsNb
     **/
    public void setInhabitantsNb(Integer inhabitantsNb) {
        this.inhabitantsNb = inhabitantsNb;
    }
}
