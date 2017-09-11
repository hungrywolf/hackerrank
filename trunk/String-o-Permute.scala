import java.util.Scanner

object Solution {
  def main (args:Array[String]){
    val in = new Scanner(System.in)
    val T = in.nextLine.toInt

    for(i <- 1 to T) {
      val L = in.nextLine
      println(swap(L))
    }


  }

  def swap (s:String) : String = {
    def swapInn(list:List[Char]):List[Char] = list match {
      case Nil => Nil
      case x::Nil => List(x)
      case x :: y :: rest => y :: x :: swapInn(rest)
    }
    swapInn(s.toList).mkString("")
  }
}

swap("abcdef",0)
