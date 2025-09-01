
package com.dio.board.dto;

import java.time.LocalDate;

public class CreateCardRequest {
    public Long laneId;
    public String title;
    public String description;
    public LocalDate dueDate;
    public String priority;
}
