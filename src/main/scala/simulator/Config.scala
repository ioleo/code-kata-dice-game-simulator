package simulator

case class Config(numberOfPlayers: Int, numberOfRounds: Int, numberOfDices: Int) {
  require(numberOfPlayers >= 2, "There must be at least 2 players")
  require(numberOfRounds >= 1, "There must be at least 1 round")
  require(numberOfDices >= 1, "There must be at least 1 dice")

  lazy val SOLO_WINNER_SCORE: Int = 2
  lazy val MANY_WINNER_SCORE: Int = 1
  lazy val LOOSER_SCORE: Int      = 0
  lazy val INITIAL_SCORE: Int     = 0
}
