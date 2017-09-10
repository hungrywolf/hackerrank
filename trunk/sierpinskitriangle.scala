case class Point(x:Int , y:Int)
case class Triangle(p:Point, size:Int)
type Board = Array[Array[Char]]

def newBoard : Board = Array.fill(32)(Array.fill(63)('_'))

def firstTriangle : Triangle = Triangle(Point(x=31, y=0), size=32)

def getPoints(triangle:Triangle) : List[Point] = {
    (for{row <- 0 to triangle.size - 1
    x <- (triangle.p.x-row) to (triangle.p.x+row)
  } yield Point(x,triangle.p.y+row)).toList
}

def fillBoard(board:Board , point:List[Point]) : Board = {
  point.foldLeft(board.clone) {case(mutatedBoard:Board, p:Point) =>
    mutatedBoard(p.y).update(p.x,'1')
    mutatedBoard
  }
}

def printBoard(board:Board) :Unit = { for(row <- board) println(row.mkString) }

def split(triangle : Triangle) : List[Triangle] = {
    List( Triangle(Point(triangle.p.x,triangle.p.y),triangle.size/2)
     ,Triangle(Point(triangle.p.x-triangle.size/2,triangle.p.y+triangle.size/2),triangle.size/2)
     ,Triangle(Point(triangle.p.x+triangle.size/2,triangle.p.y+triangle.size/2),triangle.size/2)
    )
}

def repeat(list:List[Triangle], times: Int) : List[Triangle] = {
  if (times == 0) list
  else list.foldLeft(List[Triangle]()) { case(returnList,i) =>
    returnList ++ repeat(split(i), times -1)}
}

def draw(N:Int) : Unit = {
  val points = (for {
      t <- repeat(List(firstTriangle),N)
    } yield getPoints(t)).toList.flatten
  printBoard(fillBoard(newBoard,points))
}

draw(2)
