// Concrete subclass of the abstract superclass.
public class WoodenRoom extends MazeRoom{

    public WoodenRoom(Boolean hasNorth, Boolean hasEast, Boolean hasSouth, Boolean hasWest){
        // Invokes constructor of the superclass after createDoorMethod is declared.
        super(hasNorth, hasEast, hasSouth, hasWest);
    }

    @Override
    public void description() {
        System.out.println("Wooden Room. May contain simple doors to the north, east, south, or west");
    }

    // Steel room determines that any door within this room will be simple if it exists.
    // Whether the door exists or not is determined by the constructor.

    protected MazeDoor createDoor(String Direction){
        if ((Direction.equals("north")) || (Direction.equals("east")) || (Direction.equals("south")) || (Direction.equals("west"))){
            return new SimpleDoor();
        }
        else
            return null;
    }

}
