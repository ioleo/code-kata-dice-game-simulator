package simulator

private case class Roll(number: Int)(implicit config: Config, diceRoller: DiceRoller) {
  lazy val result: Int = diceRoller.roll()

  override def toString: String = result.toString
}
