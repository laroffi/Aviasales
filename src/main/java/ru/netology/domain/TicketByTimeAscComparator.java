package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketOffer> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int time;

    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getTime() - o2.getTime();
    }

}
