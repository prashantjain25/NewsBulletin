package com.newsbulletin.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.entity.Newspaper;
import com.newsbulletin.model.HeadlineDTO;


public class HeadlineMapper {
    static List<HeadlineDTO> mapEntitiesIntoDTOs(List<Headline> entities) {
        return entities.stream().map(HeadlineMapper::mapEntityIntoDTO)
                .collect(Collectors.toList());
    }

    static HeadlineDTO mapEntityIntoDTO(Headline entity) {
        HeadlineDTO dto = new HeadlineDTO();

        dto.setArticleFeed(entity.getHeadlines());
        dto.setHeadlineUrl(entity.getHeadlineUrl());
        dto.setIdentifier(entity.getIdentifier());
        dto.setId(entity.getId());
        dto.setPublisher(entity.getNewspaper().getPublisher());
        dto.setType(entity.getType());
        

        return dto;
    }

    public static Page<HeadlineDTO> mapEntityPageIntoDTOPage(Pageable page,
            Page<Headline> source) {
        List<HeadlineDTO> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, page, source.getTotalElements());
    }
}
