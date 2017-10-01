object Solution {
    def main(args: Array[String]) {
      val board = (1 to 10).map(_ => readLine)
      val words = readLine.trim.split(';').toList

      val points = getPoints(board.map(_.toList).toList)
    }

    def getPoints(list:List[List[Char]]) : List[(Int,Int)] = {
      (for { i <- 0 to 9
          j <- 0 to 9
          if(list(i)(j) == '-')
      } yield (i,j)).toList.sortBy(_.swap)
    }
}
