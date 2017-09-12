import scala.annotation.tailrec

object Solution {

    def compress(xs: String): List[(Char, Int)] = {
        @tailrec
        def go(acc: List[(Char, Int)], ys: String): List[(Char, Int)] = {
            if(ys.isEmpty){
                acc
            } else {
                val y: Char = ys.head
                val spans: (String, String) = ys.span(_ == y)
                go((y, spans._1.length) :: acc, spans._2)
            }
        }
        go(Nil, xs).reverse
    }

    def format_count_tuple[T](tups: List[(T, Int)]): String = {
        tups.map(x => {
            if(x._2 == 1){
                s"${x._1}"
            } else {
                s"${x._1}${x._2}"
            }
        }).mkString("")
    }

    def main(args: Array[String]) {
        val xs = readLine
        println(format_count_tuple(compress(xs)))
    }
}
