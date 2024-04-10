import scala.concurrent.{ExecutionContext, Future}
import Main.*

import scala.collection.mutable

object Main {
  class GenW(wt: String = "tiny", sc: String = "")

  object Ps {
    trait Context
  }
  object Loc {
    case class Tb()
  }
  object sx {
    case class Sx()
  }
  object GTG {
    object Flat {
      def worldGen: WG = ???
    }
  }
  trait DF {
    def done: Boolean
    def errors: Seq[String]
    def maxSteps: Int
    def maxTime: Double
  }
  trait State
  trait StepVars
  trait WG
  trait TestConfig

  object FW {

    def load(implicit ctx: Ps.Context): Future[(WG, Loc.Tb, sx.Sx)] = {
      Future.successful((GTG.Flat.worldGen, Loc.Tb(), sx.Sx()))
    }
  }

  /** interactive wrapper - show the test state */
  class InteractiveTestWatch(d: DF) {
    def frameNo: Int = ???
    def elapsedTime(s: State): Double = ???

    def simulate(state: State, vars: StepVars)(implicit ec: ExecutionContext) = {
      val result = mutable.ArrayBuffer.empty[Any]
      if (d.done) {
        val errors = d.errors
        if (errors.nonEmpty) {
          println(s"Test ended with failures: ${errors.mkString(",")}")
        } else {
          println(f"Test ended OK in $frameNo frames (${elapsedTime(state)}%.2f s)")
        }
        result.append(???)
      } else if (frameNo > d.maxSteps || elapsedTime(state) > d.maxTime) {
        println(f"Test did not end: $frameNo steps, elapsed time ${elapsedTime(state)}%.2f s")
        result.append(???)
      } else {
        result
      }
    }
  }
}

/**
 * Create interactive game-like environment where test can be watched and debugged
 * This provides an entry point which is not discovered as a test, but it is a part of the Test configuration and can be run as needed from IDE or SBT
 * */

class Main(detectedFromState: State => DF, worldConfig: TestConfig, init: State => State = identity) {
  class TestInitializationJVM {
    def initialGameSettings = ???

    def createState(implicit ctx: Ps.Context, ec: ExecutionContext) = ???

    def loadWorldGen(implicit ctx: Ps.Context): Future[(WG, Loc.Tb, sx.Sx)] = ???
    def adjustScenario = identity
  }

  def main(args: Array[String]): Unit = {
  }
}
