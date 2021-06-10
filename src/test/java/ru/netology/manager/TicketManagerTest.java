package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private TicketOffer first = new TicketOffer(1, 2000, "LED", "SVO", 40);
    private TicketOffer second = new TicketOffer(2, 3000, "GOZ", "LED", 90);
    private TicketOffer third = new TicketOffer(3, 5000, "VNU", "OGZ", 145);
    private TicketOffer fourth = new TicketOffer(4, 1500, "VNU", "LED", 45);
    private TicketOffer fifth = new TicketOffer(5, 6000, "KUF", "LED", 85);
    private TicketOffer sixth = new TicketOffer(6, 2500, "LED", "FRU", 270);
    private TicketOffer seventh = new TicketOffer(7, 4000, "GOZ", "LED", 95);
    private TicketOffer eighth = new TicketOffer(8, 3500, "VNU", "OGZ", 140);
    private TicketOffer ninth = new TicketOffer(9, 5500, "KUF", "LED", 90);
    private TicketOffer tenth = new TicketOffer(10, 7500, "VNU", "OGZ", 135);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldShowAllSorted() {
    TicketOffer[] expected = new TicketOffer[]{fourth, first, sixth, second, eighth, seventh, third, ninth, fifth, tenth};
    TicketOffer[] actual = repository.findAll();
        Arrays.sort(actual);
    assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindFromTo() {
        TicketOffer[] actual = manager.findAll("Vnu", "OGZ");
        TicketOffer[] expected = new TicketOffer[]{eighth, third, tenth};
    assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNothing() {
        TicketOffer[] actual = manager.findAll("LED", "OGZ");
        TicketOffer[] expected = new TicketOffer[]{};
        assertArrayEquals(actual, expected);
    }

}