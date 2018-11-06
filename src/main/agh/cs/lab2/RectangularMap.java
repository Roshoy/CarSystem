package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;



    public RectangularMap(int width, int height){

        this.height = height;
        this.width = width;
        this.leftDownCorner = new Position(0,0);
        this.rightUpperCorner = new Position(this.width-1,this.height-1);
    }

    @Override
    public boolean canMoveTo(Position position){

        if( this.rightUpperCorner.largerThan(position) &&
                this.leftDownCorner.smallerThan(position) &&
                !isOccupied(position))return true;
        return false;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.leftDownCorner,this.rightUpperCorner);
    }




}
