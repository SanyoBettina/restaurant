package com.bettina.restaurant.api.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RestaurantTableDTO {
    @NotNull(message = "Number of tables is required.")
    @Min(value = 0, message = "Number of tables must be higher than 0.")
    private Integer nrOfTables;
    @NotNull(message = "Number of seats is required.")
    @Min(value = 0, message = "Number of seats must be higher than 0.")
    private Integer nrOfSeats;

    public Integer getNrOfTables() {
        return nrOfTables;
    }

    public void setNrOfTables(Integer nrOfTables) {
        this.nrOfTables = nrOfTables;
    }

    public Integer getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }
}
