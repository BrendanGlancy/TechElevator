package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReserveAuctionTest {

	@Test
	public void bid_is_ignored_if_less_than_reserve() {
		ReserveAuction theAuction = new ReserveAuction("The Thing", 100);
		theAuction.placeBid(new Bid("Cheapskate", 99));
		assertEquals(0, theAuction.getAllBids().size());
	}

	@Test
	public void bid_is_accepted_if_bid_is_equal_to_reserve() {
		ReserveAuction theAuction = new ReserveAuction("The Thing", 100);
		theAuction.placeBid(new Bid("Bidder Bob", 100));
		assertEquals("Bidder Bob", theAuction.getHighBid().getBidder());
		assertEquals(100, theAuction.getHighBid().getBidAmount());
	}
}
