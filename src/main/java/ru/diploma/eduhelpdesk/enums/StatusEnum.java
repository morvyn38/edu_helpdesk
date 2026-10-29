package ru.diploma.eduhelpdesk.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    NEW("new", "Новая", false),
    DISPATCHED("dispatched", "Распределена", false),
    AGENT_PENDING("agent_pending", "Агент в очереди", false),
    AGENT_WORKING("agent_working", "Агент работает", false),
    AGENT_AWAITING_APPROVAL("agent_awaiting_approval", "Ждёт подтверждения", false),
    AGENT_RESOLVED("agent_resolved", "Решена агентом", false),
    AGENT_FAILED("agent_failed", "Агент не смог", false),
    IN_PROGRESS("in_progress", "В работе", false),
    WAITING_USER("waiting_user", "Ждёт ответа", false),
    WAITING_PARTS("waiting_parts", "Ждёт запчасти", false),
    ESCALATED("escalated", "Эскалирована", false),
    RESOLVED("resolved", "Решена", true),
    CLOSED("closed", "Закрыта", true),
    REJECTED("rejected", "Отклонена", true),
    DUPLICATE("duplicate", "Дубликат", true);

    private final String dbName;
    private final String displayName;
    private final Boolean isFinal;

    StatusEnum(String dbName, String displayName, Boolean isFinal) {
        this.dbName = dbName;
        this.displayName = displayName;
        this.isFinal = isFinal;
    }

    public static StatusEnum fromDbName(String dbName) {
        for (StatusEnum status : values()) {
            if (status.dbName.equals(dbName)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + dbName);
    }
}