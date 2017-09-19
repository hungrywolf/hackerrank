import java.util.Scanner;

object Solution {

    def main(args: Array[String]) {
        val in = new Scanner(System.in)
        val N = in.nextInt

        for(i <- 0 to N-1) {
            val s = in.nextLine
            println(rottaion(s,0).mkString(" "))
        }
    }

    def rottaion(s:String,n:Int) : List[String] =  {
      if (n >= s.length) return List()
      val ss = s.tail+s.head
      List(ss) ::: rottaion(ss,n+1)
    }
}
