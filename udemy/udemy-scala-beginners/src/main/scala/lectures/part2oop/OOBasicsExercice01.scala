package lectures.part2oop

import java.time.Year

object OOBasicsExercice01 extends App {
  /*
    Novel and Writer

    Writer: first name, surname, year of birth
      methods:
        - fullname: return "first_name surname"

    Novel: name, year of release, author
      methods:
        - authorAge
        - isWrittenBy
        - copy (release a new version with current year)
  */
  val thiago = new Writer("Thiago", "Rodrigues",1991)
  println(s"This is the full name of $thiago: ${thiago.fullName()}")

  val novel = new Novel("The Birth of Pain", 2009, thiago)
  println(s"${novel.name} is published by ${novel.isWrittenBy()} in ${novel.yearOfRelease}")
  println(s"${novel.isWrittenBy()} is currently ${novel.authorAge()}")

  val newNovel = novel.copy()
  println(s"${newNovel.name} is published by ${newNovel.isWrittenBy()} in ${newNovel.yearOfRelease}")
  println(s"${newNovel.isWrittenBy()} is currently ${newNovel.authorAge()}")
}

class Writer(val firstName: String, val surname: String, val yearOfBirth: Int) {
  def fullName(): String = {
    s"$firstName $surname"
  }
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge(): Int = {
    Year.now.getValue - author.yearOfBirth
  }

  def isWrittenBy(): String = {
    author.fullName()
  }

  def copy(): Novel = {
    Novel(this.name, Year.now.getValue, this.author)
  }
}

