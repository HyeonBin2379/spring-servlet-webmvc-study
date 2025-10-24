package com.ssg.webmvc.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {

    INSTANCE;

    private final ModelMapper modelMapper;

    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // 두 객체를 매칭하여 비교하도록 허용
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE) // 매칭한 필드에 관한 접근권한을 private로 지정
                .setMatchingStrategy(MatchingStrategies.STRICT);        // 매칭 강도는 엄격하게
    }

    // 생성 및 설정한 ModelMapper를 반환
    public ModelMapper get() {
        return modelMapper;
    }
}
