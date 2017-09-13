import java.io._

val data = List("everything", "you", "want", "to", "write", "to", "the", "file")

val file = "~/Desktop/whatever.txt"
val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))
for (x <- data) {
  writer.write(x + "\n")  // however you want to format it
}
writer.close()
