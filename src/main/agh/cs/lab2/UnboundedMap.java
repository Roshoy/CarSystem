package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {


    public UnboundedMap(){
        this.leftDownCorner = new Position(0,0);
        this.rightUpperCorner = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position){

        if(!isOccupied(position))return true;
        return false;
    }

    private void updateVisionCorners(){
        ///Update upper right corner of vision
        if(!this.cars.isEmpty()) {
            this.rightUpperCorner = this.cars.get(0).getPosition();
            this.leftDownCorner = this.cars.get(0).getPosition();
            for (Car c : cars) {
                this.rightUpperCorner = c.getPosition().upperRight(this.rightUpperCorner);
                this.leftDownCorner = c.getPosition().lowerLeft(this.leftDownCorner);
            }
        }else{
            this.rightUpperCorner = new Position(0,0);
            this.leftDownCorner = new Position(0,0);
        }
    }

    @Override
    public void run(LinkedList<MoveDirection> directions){
        super.run(directions);
        updateVisionCorners();
    }

    @Override
    public String toString() {
        updateVisionCorners();
        return new MapVisualizer(this).draw(this.leftDownCorner,this.rightUpperCorner);
    }

}
