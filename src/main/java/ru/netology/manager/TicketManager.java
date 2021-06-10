package ru.netology.manager;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager() {
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }
    public void add(TicketOffer ticketOffer) {
        repository.save(ticketOffer);
    }
    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticketOffer : repository.findAll()) {
            if (ticketOffer.matches(from, to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticketOffer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
