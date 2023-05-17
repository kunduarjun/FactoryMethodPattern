// Concrete subclass of the abstract superclass.
public class BrickRoom extends MazeRoom{

    public BrickRoom(Boolean hasNorth, Boolean hasEast, Boolean hasSouth, Boolean hasWest){
        // Invokes constructor of the superclass after createDoorMethod is declared.
        super(hasNorth, hasEast, hasSouth, hasWest);
    }

    public void description() {
        System.out.println("Brick Room. May contain doors with alphabetical locks to the north, east, south, or west");
    }

    // Brick room determines that any door within this room will have an alphabetical lock if it exists.
    // Whether the door exists or not is determined by the constructor.
    protected MazeDoor createDoor(String Direction){
        if (Direction.equals("north")){return new NorthAlphabeticalLockDoor();}
        else if (Direction.equals("east")){return new EastAlphabeticalLockDoor();}
        else if (Direction.equals("south")){return new SouthAlphabeticalLockDoor();}
        else if (Direction.equals("west")){return new WestAlphabeticalLockDoor();}
        else return null;
    }

}
