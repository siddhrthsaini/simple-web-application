package org.task.core.common;

import java.util.UUID;

public class TaskObject {

    protected String id = UUID.randomUUID().toString();

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
