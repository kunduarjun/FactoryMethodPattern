// Concrete subclass of the abstract superclass.
public class SteelRoom extends MazeRoom{

    public SteelRoom(Boolean hasNorth, Boolean hasEast, Boolean hasSouth, Boolean hasWest){
        // Invokes constructor of the superclass after createDoorMethod is declared.
        super(hasNorth, hasEast, hasSouth, hasWest);
    }

    @Override
    public void description() {
        System.out.println("Steel Room. May contain doors with numeric locks to the north, east, south, or west");
    }

    // Steel room determines that any door within this room will have a numerical lock if it exists.
    // Whether the door exists or not is determined by the constructor.
    protected MazeDoor createDoor(String Direction){
        if (Direction.equals("north")){return new NorthNumericLockDoor();}
        else if (Direction.equals("east")){return new EastNumericLockDoor();}
        else if (Direction.equals("south")){return new SouthNumericLockDoor();}
        else if (Direction.equals("west")){return new WestNumericLockDoor();}
        else return null;
    }

}
