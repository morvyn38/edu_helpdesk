package ru.diploma.eduhelpdesk.enums;

import lombok.Getter;

@Getter
public enum CategoryMainEnum {

    NETWORK("network", "Сеть", "N"),
    PRINTING("printing", "Печать", "P"),
    HARDWARE("hardware", "Оборудование", "H"),
    SOFTWARE("software", "ПО", "S"),
    EQUIPMENT("equipment", "Оборудование", "E"),
    OTHER("other", "Прочее", "O");

    private final String name;
    private final String displayName;
    private final String ticketNumberPrefix;

    CategoryMainEnum(String name, String displayName, String ticketNumberPrefix) {
        this.name = name;
        this.displayName = displayName;
        this.ticketNumberPrefix = ticketNumberPrefix;
    };

    public static CategoryMainEnum fromName(String name) {
        for (CategoryMainEnum category : values()) {
            if (category.name.equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown main category: " + name);
    }
}
