package set1

import Codecs.Hex._
import PlaintextScoring._
import scala.io.Source

object Challenge4 {
  def main(args: Array[String]) = {
    val messages = Source.fromURL("http://cryptopals.com/static/challenge-data/4.txt").getLines.toList.map(decode _)
    val bytes = (0 to 255).map(_ toByte)
    val results = messages.map((m) => bytes.map((b) => m.map((a) => (a ^ b).toByte))).flatten.map(new String(_, "US-ASCII"))
    results.filter(containsWord _) foreach (println)
  }
}
