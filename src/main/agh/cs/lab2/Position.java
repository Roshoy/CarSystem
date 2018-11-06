package agh.cs.lab2;

/**
 * Created by student34 on 2018-10-09.
 */
public class Position {
    public final int x;
    public final int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    public boolean largerThan(Position other){
        return other.x <= this.x && other.y<=this.y;
    }

    public boolean smallerThan(Position other){
        return other.x >= this.x && other.y>=this.y;
    }
    public Position upperRight(Position other){

        return new Position(Math.max(this.x,other.x), Math.max(this.y, other.y));
    }
    public Position lowerLeft(Position other){

        return new Position(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }
    public Position add(Position other){
        return new Position(this.x+other.x,this.y+other.y);
    }
    public Position multiply(int k){
        return new Position(this.x*k,this.y*k);
    }
    public boolean equals(Object other){
        if(other == this)return true;
        if(!(other instanceof Position))return false;
        Position o = (Position) other;
        return o.x == this.x && o.y == this.y;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash += this.x * 31;
        hash += this.y * 41;
        return hash;
    }
}
