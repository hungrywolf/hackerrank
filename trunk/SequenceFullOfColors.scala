object Solution {

    def main(args: Array[String]) {
        val N = readInt
        val T = (1 to N).map(x => readLine).toList
        T.foreach(x => printf("%s %n",prefIndex(x).toString.capitalize))
    }

    def prefIndex (T:String) = {
      def prefx(list:List[Char] , red:Int , yellow:Int) : Boolean = {
          if(list.isEmpty)  red == 0 && yellow == 0
          else if(list.head == 'R')  red  <= 1 && prefx(list.tail,red+1,yellow)
          else if(list.head == 'G')  red  <= 1 && prefx(list.tail,red-1,yellow)
          else if(list.head == 'Y')  yellow <= 1 && prefx(list.tail,red,yellow+1)
          else if(list.head == 'B')  yellow <= 1 && prefx(list.tail,red,yellow-1)
          else false
      }
      prefx(T.toList,0,0)
    }
}
