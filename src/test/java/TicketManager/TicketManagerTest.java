package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {
    @Test
    public void sortingMultipleTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //4
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //2
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //3
        Ticket ticket6 = new Ticket("SPB", "NOR", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket7, ticket3, ticket5, ticket1};
        Ticket[] actual = manager.search("SPB", "MUR");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketNotListed() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //4
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //2
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //3
        Ticket ticket6 = new Ticket("SPB", "NSK", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "EKB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void OneTicketFromTheList() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //4
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //2
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //3
        Ticket ticket6 = new Ticket("SPB", "NSK", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("SPB", "NSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortingWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //1
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //3
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //2
        Ticket ticket6 = new Ticket("SPB", "NSK", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket5, ticket3, ticket7};
        Ticket[] actual = manager.search("SPB", "MUR", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortingWithComparatorOneTicketFromTheList() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //1
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //3
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //2
        Ticket ticket6 = new Ticket("SPB", "NSK", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("SPB", "NSK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortingWithComparatorNotListed() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "MUR", 9000, 10, 11); //1
        Ticket ticket2 = new Ticket("MUR", "SPB", 11000, 8, 11);
        Ticket ticket3 = new Ticket("SPB", "MUR", 5000, 15, 18); //3
        Ticket ticket4 = new Ticket("SPB", "MSK", 8000, 3, 9);
        Ticket ticket5 = new Ticket("SPB", "MUR", 7000, 1, 3); //2
        Ticket ticket6 = new Ticket("SPB", "NSK", 7000, 14, 19);
        Ticket ticket7 = new Ticket("SPB", "MUR", 1000, 1, 5); //4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "EKB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
