import simulator.{Config, SimulatorFacade, SixDiceRoller}
import scala.io.StdIn

object ConsoleApp extends App {
  printf("""
           |Dice game simulator
           |===================
         """.stripMargin)

  def playGame(): Unit = {
    println("")
    println("How many players?")
    val players: Int = StdIn.readInt()

    println("How many rounds?")
    val rounds: Int = StdIn.readInt()

    println("How many dices?")
    val dices: Int = StdIn.readInt()

    implicit val gameConfig = Config(players, rounds, dices)
    implicit val roller     = SixDiceRoller
    val simulation          = SimulatorFacade()

    println(s"""
        |${simulation.showGame}
        |${simulation.showWinners}""".stripMargin)

    def askToPlayAgain(): Unit = {

      println("""
               |Want to play again?
               |===================""".stripMargin)
      val playAgain: Boolean = StdIn.readBoolean()
      if (playAgain) playGame()
      else println("Goodbye!")
    }

    askToPlayAgain()
  }

  playGame()

}
