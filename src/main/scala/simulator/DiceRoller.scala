package simulator

import scala.util.Random

trait DiceRoller {
  val diceLoVal: Int
  val diceHiVal: Int

  private lazy val generator = new Random()

  def roll(): Int = diceLoVal + generator.nextInt(diceHiVal)
}

object SixDiceRoller extends DiceRoller {
  lazy val diceLoVal = 1
  lazy val diceHiVal = 6
}
