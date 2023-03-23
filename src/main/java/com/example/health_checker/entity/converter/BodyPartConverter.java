package com.example.health_checker.entity.converter;

import com.example.health_checker.entity.enums.BodyPart;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BodyPartConverter implements AttributeConverter<BodyPart,String> {
    @Override
    public String convertToDatabaseColumn(BodyPart bodyPart) {
        return bodyPart==null? null: bodyPart.getName();
    }

    @Override
    public BodyPart convertToEntityAttribute(String s) {
        return s==null?null:BodyPart.getByName(s);
    }
}
