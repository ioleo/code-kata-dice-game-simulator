package simulator

private case class Player(index: Int)(implicit config: Config, diceRoller: DiceRoller) {
  val number: Int = index + 1

  lazy val rolls: Seq[Roll] = (0 until config.numberOfDices).map(Roll(_))
  lazy val result: Int      = rolls.map(_.result).sum

  override def toString: String = s"""Player $number rolled $result [${rolls.mkString(", ")}]"""
}
