package assignment2;

import java.util.Iterator;

public class Caterpillar extends MyDoublyLinkedList<Position> {

    public Caterpillar() {
        this.addFirst(new Position(7, 7));
    }

    public Position getHead() {
        return this.peekFirst();
    }

    public void eat(Position position) {
        Position cur;
        cur = this.peekFirst();

        //add error if position same as current position
        if (cur.getX() == position.getX()) {
            if (cur.getY() + 1 == position.getY() || cur.getY() - 1 == position.getY()) {
                this.addFirst(position);
            }
        } else if (cur.getY() == position.getY()) {
            if (cur.getX() + 1 == position.getX() || cur.getX() - 1 == position.getX()) {
                this.addFirst(position);
            }
        } else {
            throw new IllegalArgumentException("Input position is not orthogonally adjacent to current head position");
        }
    }

    public void move(Position position) {
        this.eat(position);
        this.removeLast();
    }

    public boolean selfCollision(Position position) {
        Iterator<Position> iter1 = this.iterator();

        while (iter1.hasNext()) {
            if (iter1.next().equals(position)) {
                return true;
            }
        }

        return this.peekLast().equals(position);

    }
}
