package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketOffer> {

    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getTime() - o2.getTime();
    }

}
