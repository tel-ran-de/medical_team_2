package com.example.health_checker.entity.converter;

import com.example.health_checker.entity.enums.VoteType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VoteTypeConverter implements AttributeConverter<VoteType, String> {
    @Override
    public String convertToDatabaseColumn(VoteType voteType) {
        return voteType == null ? null : voteType.getName();
    }

    @Override
    public VoteType convertToEntityAttribute(String s) {
        return s == null ? null : VoteType.getByName(s);
    }
}
