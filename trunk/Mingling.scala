import java.util.Scanner

object Solution {

    def main(args: Array[String]) {
        val in = new Scanner(System.in);
        val P = in.nextLine
        val Q = in.nextLine

        println(mingling(P.toList,Q.toList).mkString(""))
    }

    def mingling(l1:List[Char],l2:List[Char]) : List[Char] = {
        if(l1.isEmpty) List()
        else
        l1.head :: l2.head :: mingling(l1.tail,l2.tail)
    }
}
