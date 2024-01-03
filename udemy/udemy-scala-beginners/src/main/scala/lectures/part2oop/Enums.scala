package lectures.part2oop

object Enums extends App {

  // Defining a enumerator
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("Opening document...")
      else println("Reading not allowed.")
  }

  val somePermission: Permissions = Permissions.READ
  somePermission.openDocument()

  val someOtherPermission: Permissions = Permissions.WRITE
  someOtherPermission.openDocument()

  // Enums with constructor arguments
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  // Enums can also have companions
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits =
      // implementation
      PermissionsWithBits.NONE
  }

  val somePermissionWithBits: PermissionsWithBits = PermissionsWithBits.fromBits(0)

  // Enum declaration index
  println(somePermissionWithBits.ordinal) // Int

  // Enum values
  println(Permissions.values) // Array[Permissions]

  // Enum from string
  println(Permissions.valueOf("READ")) // Permissions Object (value READ)
}
