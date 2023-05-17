// Concrete subclass of the abstract superclass.
public class GlassRoom extends MazeRoom{

    public GlassRoom(Boolean hasNorth, Boolean hasEast, Boolean hasSouth, Boolean hasWest){
        // Invokes constructor of the superclass after createDoorMethod is declared.
        super(hasNorth, hasEast, hasSouth, hasWest);
    }

    public void description() {
        System.out.println("Glass Room. May contain doors with quizzes to the north, east, south, or west");
    }

    // Glass room determines that any door within this room will have a quiz associated with it if it exists.
    // Whether the door exists or not is determined by the constructor.
    protected MazeDoor createDoor(String Direction){
        if (Direction.equals("north")){return new NorthQuizDoor();}
        else if (Direction.equals("east")){return new EastQuizDoor();}
        else if (Direction.equals("south")){return new SouthQuizDoor();}
        else if (Direction.equals("west")){return new WestQuizDoor();}
        else return null;
    }
}
