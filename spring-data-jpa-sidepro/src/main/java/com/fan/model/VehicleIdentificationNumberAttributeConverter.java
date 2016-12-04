package com.fan.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by fqc on 12/4/16.
 */
@Converter(autoApply = true)
public class VehicleIdentificationNumberAttributeConverter
        implements AttributeConverter<VehicleIdentificationNumber, String> {
    @Override
    public String convertToDatabaseColumn(VehicleIdentificationNumber vehicleIdentificationNumber) {
        return vehicleIdentificationNumber.toString();
    }

    @Override
    public VehicleIdentificationNumber convertToEntityAttribute(String s) {
        return new VehicleIdentificationNumber(s);
    }
}
