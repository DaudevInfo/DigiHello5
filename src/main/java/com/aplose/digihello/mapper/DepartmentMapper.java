package com.aplose.digihello.mapper;

import com.aplose.digihello.dto.DepartmentDto;
import com.aplose.digihello.model.Department;
import com.aplose.digihello.model.Town;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentDto toDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentCode(department.getCode());
        dto.setDepartmentName(department.getName());
        dto.setInhabitantsNb(department.getTowns().stream().mapToLong(Town::getNbInhabitants).sum());
        return dto;
    }

    // Impossible en l'état il manque l'ID du département
    public Department fromDto(DepartmentDto dto) {
        Department department = new Department();
        department.setCode(dto.getDepartmentCode());
        department.setName(dto.getDepartmentName());
        return department;
    }
}
