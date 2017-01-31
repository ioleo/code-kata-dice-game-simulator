package simulator

import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, Matchers}

class SimulatorFacadeSpec extends FlatSpec with Matchers with MockFactory { spec =>

  val simulator: SimulatorFacade = {
    implicit val config         = Config(3, 3, 3)
    implicit val diceRollerStub = stub[DiceRoller]

    // round 1, player 1 -- Rolls: 3, 1, 6, Total: 10
    (diceRollerStub.roll _).when().returns(3).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(1).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()
    // round 1, player 2 -- Rolls: 4, 5, 3, Total: 12
    (diceRollerStub.roll _).when().returns(4).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(5).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(3).noMoreThanOnce()
    // round 1, player 3 -- Rolls: 6, 1, 1, Total: 8
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(1).noMoreThanTwice()

    // round 2, player 1 -- Rolls: 6, 5, 5, Total: 16
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(5).noMoreThanTwice()
    // round 2, player 2 -- Rolls: 3, 4, 4, Total: 11
    (diceRollerStub.roll _).when().returns(3).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(4).noMoreThanTwice()
    // round 2, player 3 -- Rolls: 6, 4, 6, Total: 16
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(4).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()

    // round 3, player 1 -- Rolls: 2, 3, 3, Total: 8
    (diceRollerStub.roll _).when().returns(2).noMoreThanOnce()
    (diceRollerStub.roll _).when().returns(3).noMoreThanTwice()
    // round 3, player 2 -- Rolls: 1, 1, 6, Total: 8
    (diceRollerStub.roll _).when().returns(1).noMoreThanTwice()
    (diceRollerStub.roll _).when().returns(6).noMoreThanOnce()
    // round 3, player 3 -- Rolls: 2, 2, 4, Total: 8
    (diceRollerStub.roll _).when().returns(2).noMoreThanTwice()
    (diceRollerStub.roll _).when().returns(4).noMoreThanOnce()

    SimulatorFacade()
  }

  it should "show round results" in {
    simulator showRound 1 shouldBe
      """
        |Player 1 rolled 10 [3, 1, 6]
        |Player 2 rolled 12 [4, 5, 3]
        |Player 3 rolled 8 [6, 1, 1]
        |Round 1 scores [0,2,0]""".stripMargin

    simulator showRound 2 shouldBe
      """
        |Player 1 rolled 16 [6, 5, 5]
        |Player 2 rolled 11 [3, 4, 4]
        |Player 3 rolled 16 [6, 4, 6]
        |Round 2 scores [1,0,1]""".stripMargin

    simulator showRound 3 shouldBe
      """
        |Player 1 rolled 8 [2, 3, 3]
        |Player 2 rolled 8 [1, 1, 6]
        |Player 3 rolled 8 [2, 2, 4]
        |Round 3 scores [1,1,1]""".stripMargin

    simulator showRound 4 shouldBe "Couldn't show round 4 - this simulation has 3 rounds"
  }

  it should "show winners" in {
    simulator.showWinners shouldBe "Winning players 2 scored 3"
  }

}
