package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.*;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    AuctionItemRepository auctionItemRepository;
    @Autowired
    BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem TempAuctionItem;
        Bid b1, b2, b3, b4;
        Organizer org1, org2, org3;

        b1 = bidRepository.save(Bid.builder().amount(5).dateTime("2020-08-18").build());
        b2 = bidRepository.save(Bid.builder().amount(1).dateTime("2021-12-25").build());
        b3 = bidRepository.save(Bid.builder().amount(2).dateTime("2020-08-31").build());
        b4 = bidRepository.save(Bid.builder().amount(3).dateTime("2021-07-23").build());

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        b1.setAuctionitem(TempAuctionItem);
        TempAuctionItem.getBids().add(b1);
        TempAuctionItem.setSuccessfulBid(b1);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        b2.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(b2);
        TempAuctionItem.getBids().add(b2);
        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        b3.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(b3);
        TempAuctionItem.getBids().add(b3);


        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        b4.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(b4);
        TempAuctionItem.getBids().add(b4);
        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        b3.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(b3);
        TempAuctionItem.getBids().add(b3);
        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        b2.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(b2);
        TempAuctionItem.getBids().add(b2);





        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
    }
}
