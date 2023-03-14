package com.bettina.restaurant.api.util;

import com.bettina.restaurant.api.enums.DrinkTypeEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverter implements Converter<String, DrinkTypeEnum>
{
    @Override
    public DrinkTypeEnum convert(String value) {
        System.out.println("test");
        try {
            return DrinkTypeEnum.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
