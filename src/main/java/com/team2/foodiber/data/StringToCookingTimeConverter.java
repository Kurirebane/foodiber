package com.team2.foodiber.data;

import com.team2.foodiber.model.CookingTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCookingTimeConverter implements Converter<String, CookingTime> {

    @Override
    public CookingTime convert(String source) {
        return CookingTime.fromString(source);
    }
}
