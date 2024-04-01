package assignment2;

public class Position {
    private int xcoord;
    private int ycoord;

    public Position(int xcoord, int ycoord){
        this.xcoord=xcoord;
        this.ycoord=ycoord;

    }
    public Position(Position pos){
        this.xcoord = pos.xcoord;
        this.ycoord = pos.ycoord;
    }

    public void reset(int xcoord, int ycoord){
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }

    public void reset(Position pos){
        this.xcoord = pos.xcoord;
        this.ycoord = pos.ycoord;
    }

    public static int getDistance(Position pos1, Position pos2){
        int posx = pos2.xcoord - pos1.xcoord;
        int posy = pos2.ycoord - pos1.ycoord;

        if (posx<0){
            posx = posx*-1;
        }
        if (posy<0){
            posy = posy*-1;
        }
        return posx+posy;
    }

    public int getX(){
        return this.xcoord;
    }
    public int getY(){
        return this.ycoord;
    }

    public void moveWest(){
        this.xcoord= this.xcoord-1;
    }
    public void moveEast(){
        this.xcoord= this.xcoord+1;
    }
    public void moveNorth(){
        this.ycoord= this.ycoord-1;
    }
    public void moveSouth(){
        this.ycoord= this.ycoord+1;
    }

    public boolean equals(Object object){
        if (object instanceof Position){
            return this.xcoord == ((Position) object).xcoord && this.ycoord == ((Position)object).ycoord;
        }else{
            return false;
        }
    }
}

