# Jelo

The Jelo is a Java implementation of the Elo rating system, providing a straightforward and customizable solution for calculating and updating player ratings after head-to-head matches. This implementation allows users to set parameters such as the `K_FACTOR` and `DIFFERENCE_CONSTANT`, providing flexibility for different rating scenarios.

## Overview

The Elo rating system is a method for calculating the relative skill levels of players in two-player games such as chess. It takes into account the outcome of individual matches and adjusts the ratings of the players accordingly.

For more information about the Elo rating system, refer to the [Wikipedia page](https://en.wikipedia.org/wiki/Elo_rating_system).

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.

### Usage

1. Clone the repository to your local machine.

    ```bash
    git clone https://github.com/yourusername/SimpleEloEngine.git
    ```

2. Open the project in your preferred Java development environment.

3. Customize the `K_FACTOR` and `DIFFERENCE_CONSTANT` values in the `SimpleEloEngine` class to suit your requirements.

4. Use the `getUpdatedRatings` method to calculate updated Elo ratings after each match.

    ```java
    // Example usage:
    SimpleEloEngine eloEngine = new SimpleEloEngine();
    int eloPlayer1 = 1200;
    int eloPlayer2 = 1100;
    int winner = 1; // Player 1 wins

    int[] updatedRatings = eloEngine.getUpdatedRatings(eloPlayer1, eloPlayer2, winner);
    System.out.println("Updated Elo ratings: Player 1 - " + updatedRatings[0] + ", Player 2 - " + updatedRatings[1]);
    ```

## Customization

Adjust the values of `K_FACTOR` and `DIFFERENCE_CONSTANT` in the `SimpleEloEngine` constructor to customize the behavior of the Elo rating calculations.

```java
// Customized EloEngine with K_FACTOR = 24 and DIFFERENCE_CONSTANT = 200
SimpleEloEngine customizedEloEngine = new SimpleEloEngine(24, 200);

