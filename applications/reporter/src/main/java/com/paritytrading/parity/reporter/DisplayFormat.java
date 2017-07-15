package com.paritytrading.parity.reporter;

import static com.paritytrading.parity.reporter.Formats.*;

import com.paritytrading.parity.util.Timestamps;

class DisplayFormat implements TradeListener {

    private static final String HEADER = "" +
        "Timestamp    Inst     Quantity   Price     Buyer    Seller\n" +
        "------------ -------- ---------- --------- -------- --------";

    public DisplayFormat() {
        printf("\n%s\n", HEADER);
    }

    @Override
    public void trade(Trade event) {
        printf("%12s %-8s %10d %9.2f %-8s %-8s\n",
                formatTimestamp(event.timestamp), formatString(event.instrument),
                event.quantity, formatPrice(event.price), formatString(event.buyer),
                formatString(event.seller));
    }

}
