package org.task.core.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllEnum {

    private static Logger logger = LoggerFactory.getLogger(AllEnum.class);


    public enum Modules {
        course;
    }

    public enum FieldType {
        STRING, BOOLEAN, ENUM, DATE, NUMBER, INTEGER, UUID;
    }
}
