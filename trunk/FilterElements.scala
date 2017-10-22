import scala.collection.mutable._
object Solution {

    def main(args: Array[String]) {
      val T = readInt
      for (i <- 1 to T) {
        val NK = readLine.split(" ")
        val N = NK(0)
        val K = NK(1).toInt

        val list = readLine.split(" ").map(_.toInt).toList

        val tupMap = list.zipWithIndex.map(x => (x,1))
        val group = tupMap.groupBy(_._1._1)
        val result = LinkedHashMap(group.toSeq.sortBy(_._2.head._1._2):_*).filter(x => x._2.size >= K)
        if (result.size == 0) println(-1) else println(result.map(x => x._1).mkString(" "))
      }
    }
}
