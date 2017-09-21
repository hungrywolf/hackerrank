import java.util.Scanner;
import scala.collection.immutable.ListMap

object Solution {
    type MapChar = Map[Char,Int]

    def main(args: Array[String]) {
      val in = new Scanner(System.in)

      val s = in.nextLine

      println(dedup(s))

    }

    def dedup (s:String) : String = {
      def fellMap(map:MapChar,list:List[Char],n:Int) : MapChar =
        list match {
          case Nil => map
          case key :: rest => if(map.get(key) != None) fellMap(map,rest,n+1) else fellMap(map ++ Map(key -> n),rest,n+1)
      }
    ListMap(fellMap(Map(),s.toList,0).toSeq.sortBy(_._2):_*).map(m => m._1).mkString("")
  }
}
