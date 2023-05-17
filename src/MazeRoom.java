// We will be creating an abstract class for Maze Rooms that concrete maze rooms will inherit from.
// As per this assignment, we will be using the Factory Method Pattern.
// Inheritance will be used to decide which doors will be instantiated.
public abstract class MazeRoom {

    // We will use boolean values to indicate whether a door exists to the north, east, south, or west of the room.
    // Values of these boolean variables will be declared in the constructor of the concrete Rooms.
    private Boolean hasNorth;
    private Boolean hasEast;
    private Boolean hasSouth;
    private Boolean hasWest;

    // An array of fixed length 4 will be used to store the doors contained within the room, if they exist.
    // Ordered north, east, south, west.
    protected MazeDoor[] roomDoors = new MazeDoor[4];

    // Boolean values will be added inside the constructor to indicate which directions doors will exist.
    // The concrete subclasses will determine what types of concrete doors will be created by implementing the createDoor method.
    public MazeRoom(Boolean hasNorth, Boolean hasEast, Boolean hasSouth, Boolean hasWest){
        this.hasNorth = hasNorth;
        if (this.hasNorth) roomDoors[0] = this.createDoor("north");
        this.hasEast = hasEast;
        if (this.hasEast) roomDoors[1] = this.createDoor("east");
        this.hasSouth = hasSouth;
        if (this.hasSouth) roomDoors[2] = this.createDoor("south");
        this.hasWest = hasWest;
        if (this.hasWest) roomDoors[3] = this.createDoor("west");
    }

    // A general description of the room will be printed to the system upon calling this method.
    // Will describe what type of room it is and what types of doors it may contain.
    public abstract void description();

    // Subclasses will decide what type of concrete door to instantiate.
    protected abstract MazeDoor createDoor(String Direction);


    // Public getter methods for private instance variables.
    public MazeDoor getNorthDoor(){
        if (hasNorth) return roomDoors[0];
        else return null;
    }

    public MazeDoor getEastDoor(){
        if (hasEast) return roomDoors[1];
        else return null;
    }

    public MazeDoor getSouthDoor(){
        if (hasSouth) return roomDoors[2];
        else return null;
    }

    public MazeDoor getWestDoor(){
        if (hasWest) return roomDoors[3];
        else return null;
    }
}
