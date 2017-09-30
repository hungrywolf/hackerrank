object Solution {

    def numberOfWays(X:Int,N:Int,i:Int):Int = {
      val v = X-Math.pow(i,N).toInt

      v match {
        case 0 => return 1
        case j if j<0 => return 0
        case _ => return numberOfWays(v,N,i+1) + numberOfWays(X,N,i+1)
      }
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt(),readInt(),1))
    }
}
