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
        Bid TempBid;
        Organizer org1, org2, org3;

////1/////
        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        TempBid = bidRepository.save(Bid.builder().amount(5).dateTime("2020-08-18").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        TempBid = bidRepository.save(Bid.builder().amount(1).dateTime("2021-12-25").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch me if u can").type("gold").build());
        TempBid =bidRepository.save(Bid.builder().amount(2).dateTime("2020-08-31").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);
/////2//////

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        TempBid= bidRepository.save(Bid.builder().amount(3).dateTime("2021-07-23").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        TempBid= bidRepository.save(Bid.builder().amount(5).dateTime("2020-08-18").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch fish babe").type("silver").build());
        TempBid = bidRepository.save(Bid.builder().amount(2).dateTime("2020-08-31").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        /////3//////

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch lovely tood").type("Dark age").build());
        TempBid= bidRepository.save(Bid.builder().amount(1).dateTime("2021-12-25").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch lovely tood").type("Dark age").build());
        TempBid= bidRepository.save(Bid.builder().amount(5).dateTime("2020-08-18").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);

        TempAuctionItem = auctionItemRepository.save(AuctionItem.builder().description("catch lovely tood ").type("Dark age").build());
        TempBid = bidRepository.save(Bid.builder().amount(3).dateTime("2021-07-23").build());
        TempBid.setAuctionitem(TempAuctionItem);
        TempAuctionItem.setSuccessfulBid(TempBid);
        TempAuctionItem.getBids().add(TempBid);





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
