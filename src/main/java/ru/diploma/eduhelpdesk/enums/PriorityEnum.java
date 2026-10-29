package ru.diploma.eduhelpdesk.enums;

import lombok.Getter;

@Getter
public enum PriorityEnum {

    LOW("low", "Низкий", 3),
    MEDIUM("medium", "Средний", 2),
    HIGH("high", "Высокий", 1),
    CRITICAL("critical", "Критический", 0);

    private final String name;
    private final String displayName;
    private final Integer level;

    PriorityEnum(String name, String displayName, Integer level) {
        this.name = name;
        this.displayName = displayName;
        this.level = level;
    }

    public static PriorityEnum fromName(String name) {
        for (PriorityEnum priorityEnum : values()) {
            if (priorityEnum.name.equals(name)) {
                return priorityEnum;
            }
        }
        throw new IllegalArgumentException("Unknown priority: " + name);
    }
}
