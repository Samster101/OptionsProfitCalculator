# Options Calculator

A Java-based command-line application for calculating profit and loss (P&L) for options trading positions including calls, puts, and stock shares.

## Features

- **Buy/Sell Call Options**: Track long and short call positions
- **Buy/Sell Put Options**: Track long and short put positions  
- **Buy Stock Shares**: Track stock positions
- **P&L Analysis**: Calculate profit/loss across a range of stock prices
- **Interactive CLI**: Simple command-line interface for managing positions

## Project Structure

```
options calculator/
├── Main.java          # Entry point - creates Options instance
├── Options.java       # Main class with interactive CLI
├── Holding.java       # Interface for all position types
├── Call.java          # Call option implementation
├── Put.java           # Put option implementation
├── BuyShare.java      # Stock share implementation
└── README.md          # This file
```

## How It Works

### Core Classes

- **`Holding`**: Interface that defines the contract for all position types (calls, puts, shares)
- **`Call`**: Represents a call option with strike price, premium, and buy/sell flag
- **`Put`**: Represents a put option with strike price, premium, and buy/sell flag
- **`BuyShare`**: Represents a stock position with buy price and quantity
- **`Options`**: Main class that manages the portfolio and provides the interactive interface

### P&L Calculation

- **Call Options (Buy)**: 
  - If stock price > strike: `(stockPrice - strikePrice) * 100 - premium`
  - Otherwise: `-premium`
  
- **Call Options (Sell)**:
  - If stock price > strike: `-((stockPrice - strikePrice) * 100 - premium)`
  - Otherwise: `premium`

- **Put Options (Buy)**:
  - If stock price < strike: `(strikePrice - stockPrice) * 100 - premium`
  - Otherwise: `-premium`
  
- **Put Options (Sell)**:
  - If stock price < strike: `-((strikePrice - stockPrice) * 100 - premium)`
  - Otherwise: `premium`

- **Stock Shares**: `(endPrice - buyPrice) * quantity`

## Compilation and Running

### Prerequisites
- Java JDK 8 or higher

### Compile
```bash
javac *.java
```

### Run
```bash
java Main
```

## Usage

When you run the program, you'll be prompted with a menu. Enter one of the following commands:

### Commands

- **`BC`** - Buy Call
  - Enter strike price
  - Enter premium
  
- **`SC`** - Sell Call
  - Enter strike price
  - Enter premium
  
- **`BP`** - Buy Put
  - Enter strike price
  - Enter premium
  
- **`SP`** - Sell Put
  - Enter strike price
  - Enter premium
  
- **`BS`** - Buy Share
  - Enter buy price
  - Enter quantity
  
- **`end`** - Calculate P&L for price range
  - Enter end price range start
  - Enter end price range end
  - The program will calculate P&L for prices from start to end in $0.25 increments
  - Displays a table of price vs. P&L for all positions combined

### Example Session

```
Enter BC to buy call, SC to sell call, BS to buy share, etc 
BC
Enter strike price: 
100
Enter premium: 
5
Enter BC to buy call, SC to sell call, BS to buy share, etc 
BS
Enter buy price: 
95
Enter quantity: 
10
Enter BC to buy call, SC to sell call, BS to buy share, etc 
end
Enter end price range start: 
90
Enter end price range end: 
110
Price: 90.0 P&L: -550.0
Price: 90.25 P&L: -525.0
...
Price: 110.0 P&L: 450.0
```

## Design Patterns

- **Interface Pattern**: The `Holding` interface allows all position types (Call, Put, BuyShare) to be stored in a single `ArrayList<Holding>`, enabling polymorphic behavior.

## Notes

- All options contracts represent 100 shares (standard contract size)
- Premiums are entered as total premium paid/received (not per share)
- The price range analysis increments by $0.25 by default
- The program runs until you enter the `end` command

## License

This project is provided as-is for educational and personal use.

