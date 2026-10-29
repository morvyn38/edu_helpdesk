package ru.diploma.eduhelpdesk.enums;

import lombok.Getter;

@Getter
public enum CategorySubEnum {

    // Интернет
    NO_INTERNET("no_internet", "Нет интернета", CategoryMainEnum.NETWORK),
    SLOW_INTERNET("slow_internet", "Медленный интернет", CategoryMainEnum.NETWORK),
    NETWORK_SHARE("network_share", "Сетевая папка", CategoryMainEnum.NETWORK),
    WIFI("wifi", "Wi-Fi", CategoryMainEnum.NETWORK),
    DOMAIN("domain", "Домен", CategoryMainEnum.NETWORK),

    // Печать
    PRINTER_NOT_PRINTING("printer_not_printing", "Принтер не печатает", CategoryMainEnum.PRINTING),
    PRINT_QUEUE_STUCK("print_queue_stuck", "Очередь зависла", CategoryMainEnum.PRINTING),
    PRINTER_OFFLINE("printer_offline", "Принтер offline", CategoryMainEnum.PRINTING),
    PRINT_GARBLED("print_garbled", "Кракозябры", CategoryMainEnum.PRINTING),
    TONER_PAPER("toner", "Тонер", CategoryMainEnum.PRINTING),
    SCANNER("scanner", "Не сканирует", CategoryMainEnum.PRINTING),

    // Оборудование
    MOUSE("mouse", "Мышь", CategoryMainEnum.HARDWARE),
    KEYBOARD("keyboard", "Клавиатура", CategoryMainEnum.HARDWARE),
    MONITOR("monitor", "Монитор", CategoryMainEnum.HARDWARE),
    PROJECTOR("projector", "Проектор", CategoryMainEnum.HARDWARE),
    SOUND("sound", "Звук", CategoryMainEnum.HARDWARE),
    WEBCAM("webcam", "Веб-камера", CategoryMainEnum.HARDWARE),
    PC_NOT_BOOTING("pc_not_booting", "ПК не включается", CategoryMainEnum.HARDWARE),
    BSOD("bsod", "Синий экран", CategoryMainEnum.HARDWARE),

    // ПО
    APP_NOT_STARTING("app_not_starting", "Не запускается", CategoryMainEnum.SOFTWARE),
    APP_FROZEN("app_frozen", "Зависло", CategoryMainEnum.SOFTWARE),
    LICENSE_ERROR("license_error", "Ошибка лицензии", CategoryMainEnum.SOFTWARE),
    UPDATE_ERROR("update_error", "Обновление", CategoryMainEnum.SOFTWARE),
    SLOW_PC("slow_pc", "Медленно работает", CategoryMainEnum.SOFTWARE),
    LOW_DISK_SPACE("low_disk_space", "Мало места", CategoryMainEnum.SOFTWARE),

    // Учебное оборудование
    CLASSROOM_PROJECTOR("classroom_projector", "Проектор в аудитории", CategoryMainEnum.EQUIPMENT),
    CLASSROOM_SOUND("classroom_sound", "Звук в аудитории", CategoryMainEnum.EQUIPMENT);

    private final String name;
    private final String displayName;
    private final CategoryMainEnum parent;

    CategorySubEnum(String name, String displayName, CategoryMainEnum parent) {
        this.name = name;
        this.displayName = displayName;
        this.parent = parent;
    }

    public static CategorySubEnum fromName(String name) {
        for (CategorySubEnum sub : values()) {
            if (sub.name.equals(name)) {
                return sub;
            }
        }
        throw new IllegalArgumentException("Unknown sub category: " + name);
    }

    public static java.util.List<CategorySubEnum> byParent(CategoryMainEnum parent) {
        return java.util.Arrays.stream(values())
                .filter(sub -> sub.parent == parent)
                .toList();
    }
}
