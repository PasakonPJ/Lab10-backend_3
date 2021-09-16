package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Organizer;

import java.util.Optional;

public interface AuctionItemDao {
    Page< AuctionItem> getAuctionItem(Pageable pageRequest);
    Optional<AuctionItem> findById(Long id);
}
