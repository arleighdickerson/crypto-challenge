package set1
import scala.io.Source
object PlaintextScoring {
  val frequencies: Map[Char, Double] = Map(
    'a' -> 8.167, 'b' -> 1.492, 'c' -> 2.782, 'd' -> 4.253, 'e' -> 12.702, 'f' -> 2.228, 'g' -> 2.015, 'h' -> 6.094, 'i' -> 6.966,
    'j' -> 0.153, 'k' -> 0.772, 'l' -> 4.025, 'm' -> 2.406, 'n' -> 6.749, 'o' -> 7.507, 'p' -> 1.929, 'q' -> 0.095, 'r' -> 5.987, 's' -> 6.327, 't' -> 9.056,
    'u' -> 2.758, 'v' -> 0.978, 'w' -> 2.360, 'x' -> 0.150, 'y' -> 1.974, 'z' -> 0.074)

  lazy val words = Source
    .fromFile("/usr/share/dict/words")
    .getLines
    .filter(_.size > 3) //throw out really short stuff
    .toSet

  def byCharacters(string: String) = string.map((char) => frequencies.getOrElse[Double](char.toLower, 0)).sum //derp
  def byWords(string: String) = string.split("\\s+").toSet.intersect(words).size
  def containsWord(s: String) = s.split("\\s+").toSet exists words
}
