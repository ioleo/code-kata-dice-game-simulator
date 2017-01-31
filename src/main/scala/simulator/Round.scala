package simulator

private case class Round(index: Int)(implicit config: Config, diceRoller: DiceRoller) {
  val number: Int = index + 1

  lazy val players: Seq[Player] = (0 until config.numberOfPlayers).map(Player(_))
  lazy val highestResult: Int = players.foldLeft(0)(
    (hiResult, player) =>
      if (player.result > hiResult) player.result
      else hiResult
  )

  lazy val soloWinner: Boolean = players.count(_.result == highestResult) == 1
  lazy val winnerScore: Int    = if (soloWinner) config.SOLO_WINNER_SCORE else config.MANY_WINNER_SCORE
  lazy val scores: Seq[Int]    = players.map(p => if (p.result == highestResult) winnerScore else config.LOOSER_SCORE)

  override def toString: String =
    s"""
       |${players.mkString("\n")}
       |Round $number scores [${scores.mkString(",")}]""".stripMargin
}
