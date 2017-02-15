# code-kata-dice-game-simulator

Write a dice simulator. The game is played by P players (at least two) and takes R rounds (at least one). 
Each round each player rolls D 6-sided dices (at least one) and sums the results. Each round players 
totals are compared and gain scores. Loosers gain 0 points. If there is a solo winner, he gets 2 points. 
If there is a draw among the winners, each gets 1 point.

```
val p: Int = 2
val r: Int = 4
val d: Int = 3
```

Which represents following information:

* number of players - 2
* number of rounds - 4
* number of dices - 3

> Note: the solution should take form of an interactive console application. User should be asked to provide
> the simulation parameters.

As a result, the game progress should be printed to console, with detailed information about each players rolls
in each rounds, so the winner can be manually confirmed.
