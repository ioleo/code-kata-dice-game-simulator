package simulator

case class SimulatorFacade(implicit config: Config, diceRoller: DiceRoller) {

  private lazy val game = Game()

  def showRound(number: Int): String = {
    val roundIndex: Int = number - 1

    if (number <= config.numberOfRounds)
      game.rounds(roundIndex).toString
    else
      s"Couldn't show round $number - this simulation has ${config.numberOfRounds} rounds"
  }

  lazy val showWinners: String = s"""Winning players ${game.winners.mkString(", ")} scored ${game.hiscore}"""

  lazy val showGame: String = game.toString

}
