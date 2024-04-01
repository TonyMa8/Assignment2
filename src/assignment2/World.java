package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position curFoodPosition;
    private Region map;
    private ActionQueue actions;
    private TargetQueue foodPosition;
    private GameState curr;

    public World(TargetQueue t, ActionQueue a){
        this.actions = a;
        this.foodPosition = t;
        this.map = new Region(0,0,15,15);
        this.caterpillar = new Caterpillar();//size 1 & pos(7,7)
        curFoodPosition = foodPosition.dequeue();
        curr = curr.MOVE;

    }

    public void step() {
        Direction nextPos = null;
        Position newPos;
        Position curPosition;
        if (this.actions.isEmpty()) {
            curr = curr.NO_MORE_ACTION;
        }else{
            nextPos = this.actions.dequeue();
        }

        if (curr != GameState.MOVE && curr != GameState.EAT){
            return;
        }
        //how to get head without updating it
        curPosition = caterpillar.getHead();
        newPos = new Position(curPosition);
        switch (nextPos) {
            case NORTH:
                newPos.moveNorth();
                break;
            case SOUTH:
                newPos.moveSouth();
                break;
            case EAST:
                newPos.moveEast();
                break;
            case WEST:
                newPos.moveWest();
                break;
        }

        if (!map.contains(newPos)){
            curr = curr.WALL_COLLISION;
        }

        else if (caterpillar.selfCollision(newPos)){
            curr = curr.SELF_COLLISION;
        }

        else if(curFoodPosition.equals(newPos)){
            caterpillar.eat(curFoodPosition);
            if (foodPosition.isEmpty()){
                curr = curr.DONE;
            }else{
                curFoodPosition = foodPosition.dequeue();
                curr = curr.EAT;
            }
        }

        else{
            caterpillar.move(newPos);
        }

    }

    public GameState getState(){
        return curr;
    }

    public Caterpillar getCaterpillar(){
        return caterpillar;
    }

    public Position getFood(){
        return curFoodPosition;
    }

    public boolean isRunning(){
        if (curr == GameState.MOVE || curr == GameState.EAT){
            return true;
        }
        return false;
    }
}
