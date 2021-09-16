package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.repository.AuctionItemRepository;

import java.util.Optional;
@Repository
public class AuctionItemDaoImpl implements AuctionItemDao{
   @Autowired
    AuctionItemRepository auctionItemRepository;
    @Override
    public Page<AuctionItem> getAuctionItem(Pageable pageRequest) {
        return auctionItemRepository.findAll(pageRequest);
    }

    @Override
    public Optional<AuctionItem> findById(Long id) {
        return auctionItemRepository.findById(id);
    }
}
