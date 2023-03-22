package com.example.health_checker.entity.converter;

import com.example.health_checker.entity.enums.IndexType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IndexTypeConverter implements AttributeConverter<IndexType, String> {
    @Override
    public String convertToDatabaseColumn(IndexType indexType) {
        return indexType == null ? null : indexType.getName();
    }

    @Override
    public IndexType convertToEntityAttribute(String s) {
        return s == null ? null : IndexType.getByName(s);
    }
}
