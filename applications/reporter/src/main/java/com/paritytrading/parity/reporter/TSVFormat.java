package com.paritytrading.parity.reporter;

import static com.paritytrading.parity.reporter.Formats.*;

import com.paritytrading.parity.util.Timestamps;

class TSVFormat implements TradeListener {

    private static final String HEADER = "" +
        "Timestamp\t" +
        "Match Number\t" +
        "Instrument\t" +
        "Quantity\t" +
        "Price\t" +
        "Buyer\t" +
        "Buy Order Number\t" +
        "Seller\t" +
        "Sell Order Number\n";

    public TSVFormat() {
        printf(HEADER);
    }

    @Override
    public void trade(Trade event) {
        printf("%s\t%d\t%s\t%d\t%.2f\t%s\t%d\t%s\t%d\n",
                formatTimestamp(event.timestamp), event.matchNumber,
                formatString(event.instrument), event.quantity,
                formatPrice(event.price), formatString(event.buyer),
                event.buyOrderNumber, formatString(event.seller),
                event.sellOrderNumber);
    }

}
