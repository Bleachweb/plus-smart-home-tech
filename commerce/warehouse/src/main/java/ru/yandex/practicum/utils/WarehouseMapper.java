package ru.yandex.practicum.utils;

import ru.yandex.practicum.dto.warehouse.DimensionDto;
import ru.yandex.practicum.model.Dimension;

public class WarehouseMapper {
    public static Dimension fromDimensionDto(DimensionDto dimensionDto) {
        return Dimension.builder()
                .depth(dimensionDto.getDepth())
                .width(dimensionDto.getWidth())
                .height(dimensionDto.getHeight())
                .build();
    }
}