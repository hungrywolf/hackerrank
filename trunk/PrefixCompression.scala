object Solution {

    def main(args: Array[String]) {
      val x = readLine
      val y = readLine

      val i = prefIndex2(x,y,0)
      val pref = x.substring(0,i)
      val x1 = x.substring(pref.size,x.length)
      val y1 = y.substring(pref.size,y.length)
      println(s"${pref.size} ${pref}")
      println(s"${x1.size} ${x1}")
      println(s"${y1.size} ${y1}")

    }

    def prefIndex (x:String , y:String , i:Int) : Int = {
      if(i < 0) return 0
      if(i == x.size) return i
      if(i == y.size) return i
      if(x.charAt(i) == y.charAt(i)) return prefIndex(x,y,i+1)
      return i
    }
    // my Solution
    def prefIndex2 (x:String , y:String , i:Int) : Int = {
      def prefIndex2In(xx:List[Char] , yy:List[Char] , ii:Int) : Int ={
        if(xx.size==0) return ii
        if(yy.size==0) return ii
        if(xx.head == yy.head) return prefIndex2In(xx.tail,yy.tail, ii+1)
        return ii
      }
      prefIndex2In(x.toList,y.toList,i)
    }
}
