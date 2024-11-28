package com.aplose.digihello.mapper;

import com.aplose.digihello.dto.TownDto;
import com.aplose.digihello.model.Department;
import com.aplose.digihello.model.Town;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class TownMapper {
    public TownDto toDto(Town town) {
        TownDto dto = new TownDto();

        dto.setId(town.getId());
        dto.setName(town.getName());
        dto.setDepartmentCode(town.getDepartment().getCode());
        dto.setDepartmentName(town.getDepartment().getName());
        dto.setInhabitantsNb(town.getNbInhabitants());
        return dto;
    }

    public Town fromDto(TownDto dto, Department department) {
        Town town = new Town();
        town.setId(dto.getId());
        town.setName(dto.getName());
        town.setNbInhabitants(dto.getInhabitantsNb());
        town.setDepartment(department);
        return town;
    }

    public Iterable<TownDto> toDtos(Iterable<Town> towns) {
       ArrayList<TownDto> dtos = new ArrayList<>();
       for (Town town : towns) {
           dtos.add(toDto(town));
       }
       return dtos;
    }

}
