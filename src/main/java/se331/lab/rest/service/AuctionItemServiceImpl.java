package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AuctionItemDao;
import se331.lab.rest.entity.AuctionItem;

import java.util.List;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {
    @Autowired
    AuctionItemDao auctionItemDao;

    @Override
    public List<AuctionItem> getAllAuctionItem() {
        return auctionItemDao.getAuctionItem(Pageable.unpaged()).getContent();
    }
}
