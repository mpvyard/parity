# PMR

PMR is Parity's native market reporting protocol.

## Architecture

PMR consists of logical, sequenced messages sent by the trading system to
a client application.

PMR uses NASDAQ MoldUDP64 1.00 as the underlying transport protocol. It
implements ordered, reliable IP multicast.

## Data Types

Number fields are encoded as unsigned integers in network byte order.

Text fields are encoded as ASCII, left-justified and padded on the right with
the space character.

Prices have decimal fixed-point representation with a six-digit integral part
and a four-digit fractional part.

Timestamps are represented as nanoseconds since the midnight of the day on
which the trading session started.

## Messages

All messages are sent by the trading system to the client application.

### Version

A Version message indicates the protocol version. The trading system sends a
Version message as the first message in a trading session.

Name         | Length | Type   | Notes
-------------|--------|--------|------
Message Type |      1 | Text   | `V`
Version      |      4 | Number | 1

### Order Entered

An Order Entered message indicates that an order has been entered. The order
number is the trading system's identifier for the order.

Name         | Length | Type   | Notes
-------------|--------|--------|----------
Message Type |      1 | Text   | `E`
Timestamp    |      8 | Number |
Username     |      8 | Text   |
Order Number |      8 | Number |
Side         |      1 | Text   | See below
Instrument   |      8 | Text   |
Quantity     |      4 | Number |
Price        |      4 | Number |

The sides are enumerated below.

Side | Description
-----|------------
`B`  | Buy
`S`  | Sell

### Cancel

A Cancel message indicates that an order has been canceled in part or fully.

Name              | Length | Type   | Notes
------------------|--------|--------|------
Message Type      |      1 | Text   | `X`
Timestamp         |      8 | Number |
Username          |      8 | Text   |
Order Number      |      8 | Number |
Canceled Quantity |      4 | Number |

### Trade

A Trade message indicates that a trade has taken place. The match number and
the order numbers are the trading system's identifiers for the trade and the
executed orders, respectively.

Name              | Length | Type   | Notes
------------------|--------|--------|------
Message Type      |      1 | Text   | `T`
Timestamp         |      8 | Number |
Match Number      |      4 | Number |
Instrument        |      8 | Text   |
Quantity          |      4 | Number |
Price             |      4 | Number |
Buyer             |      8 | Text   |
Buy Order Number  |      8 | Number |
Seller            |      8 | Text   |
Sell Order Number |      8 | Number |

## History

- **Version 1.** Initial version.
