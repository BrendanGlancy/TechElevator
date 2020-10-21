package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuyoutAuctionTest {

	@Test
	public void bids_made_after_buyout_price_met_are_ignored() {
		BuyoutAuction theAuction = new BuyoutAuction("The Thing", 100);
		theAuction.placeBid(new Bid("Buyout Bob", 100));
		theAuction.placeBid(new Bid("Too Late Tom", 101));
		assertEquals(1, theAuction.getAllBids().size());
		assertEquals("Buyout Bob", theAuction.getHighBid().getBidder());
		assertEquals(100, theAuction.getHighBid().getBidAmount());
	}

	@Test
	public void bids_greater_than_buyout_price_are_reduced_to_buyout_price() {
		BuyoutAuction theAuction = new BuyoutAuction("The Thing", 100);
		theAuction.placeBid(new Bid("Big Spender", 200));
		assertEquals("Big Spender", theAuction.getHighBid().getBidder());
		assertEquals(100, theAuction.getHighBid().getBidAmount());
	}
	
}
