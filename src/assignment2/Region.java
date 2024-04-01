package assignment2;

public class Region {
    private int minx;
    private int miny;
    private int maxx;
    private int maxy;

    public Region(int minx, int miny, int maxx, int maxy){
        this.minx = minx;
        this.miny = miny;
        this.maxx = maxx;
        this.maxy = maxy;
    }

    public boolean contains(Position position){
        if (this.minx <= position.getX() && this.miny <= position.getY()){
            if (this.maxx >= position.getX() && this.maxy >= position.getY()){
                return true;
            }
            return false;
        }
        return false;
    }


}
