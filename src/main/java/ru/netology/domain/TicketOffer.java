package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int time;

    @Override
    public int compareTo(TicketOffer o) {
    return price - o.price;
    }

    public boolean matches(String from, String to) {
        return airportFrom.equalsIgnoreCase(from) && airportTo.equalsIgnoreCase(to);
    }
}

