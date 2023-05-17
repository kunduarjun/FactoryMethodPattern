// Driver class for the maze.

public class TestDrive {

    public static void main(String[] args){
        // Instantiate variables with each specific type of room.
        MazeRoom bricks = new BrickRoom(true, true, false, false);
        MazeRoom glass = new GlassRoom(true, false, false, true);
        MazeRoom steel = new SteelRoom(true, false, true, false);
        MazeRoom wood = new WoodenRoom(false, true, true, true);

        // Test that the description method works.
        bricks.description();
        glass.description();
        steel.description();
        wood.description();
        System.out.println();

        // Test that we can get a door from any direction.
        // May need to use try ... catch blocks, based on what door is chosen for each room.
        // For simplicity, I'm just going to use doors that I know exist in that specific direction for that specific room.
        MazeDoor bricksEast = bricks.getEastDoor();
        MazeDoor glassWest = glass.getWestDoor();
        MazeDoor steelNorth = steel.getNorthDoor();
        MazeDoor woodSouth = wood.getSouthDoor();

        // Test methods of each type of door: simple, numeric lock, alphabetical lock, and quiz.

        bricksEast.openDoor();
        bricksEast.getDoorStatus();
        bricksEast.getPassword();
        bricksEast.unlock();
        bricksEast.getDoorStatus();
        bricksEast.unlock();
        System.out.println();

        woodSouth.openDoor();
        woodSouth.getDoorStatus();
        woodSouth.getPassword();
        woodSouth.unlock();
        System.out.println();

        steelNorth.openDoor();
        steelNorth.getDoorStatus();
        steelNorth.getPassword();
        try {steelNorth.unlock();} catch (Exception e){System.out.println("Please print out a number next time");}
        steelNorth.getDoorStatus();
        try {steelNorth.unlock();} catch (Exception e){System.out.println("Please print out a number next time");}
        System.out.println();

        glassWest.openDoor();
        glassWest.getDoorStatus();
        glassWest.getPassword();
        glassWest.showQuiz();
        glassWest.unlock();
        glassWest.getDoorStatus();
        glassWest.unlock();
        System.out.println();

        // Hopefully everything should pass the tests!!
    }
}
