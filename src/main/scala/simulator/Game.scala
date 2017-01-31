package simulator

private case class Game(implicit config: Config, diceRoller: DiceRoller) {
  lazy val rounds: Seq[Round] = (0 until config.numberOfRounds).map(Round(_))
  lazy val scores: Seq[Int] = rounds
    .flatMap(_.scores.zipWithIndex)
    .groupBy(_._2) // group by player
    .toSeq
    .sortBy(_._1) // sort by player
    .map { case (player, roundScores) => roundScores.map(_._1).sum }

  lazy val hiscore: Int = scores.foldLeft(0)((hi, next) => if (next > hi) next else hi)
  lazy val winners: Seq[Int] = scores.zipWithIndex
    .filter { case (score, player) => score == hiscore }
    .map { case (score, player) => player + 1 }

  override def toString: String =
    s"""
       |${rounds.mkString("\n")}
       |
       |Game total scores [${scores.mkString(",")}]""".stripMargin
}
