package agh.cs.lab2;

import java.util.LinkedList;

public class UnboundedMap extends AbstractWorldMap {


    public UnboundedMap(){
        this.setLeftDownCorner(new Position(0,0));
        this.setRightUpperCorner(new Position(0,0));
    }

    @Override
    public boolean canMoveTo(Position position){

        if(!isOccupied(position))return true;
        return false;
    }

    private void updateVisionCorners(){
        ///Update upper right corner of vision
        if(!this.getCars().isEmpty()) {
            this.setRightUpperCorner(this.getCars().get(0).getPosition());
            this.setLeftDownCorner(this.getCars().get(0).getPosition());
            for (Car c : getCars()) {
                this.setRightUpperCorner(c.getPosition().upperRight(this.getRightUpperCorner()));
                this.setLeftDownCorner(c.getPosition().lowerLeft(this.getLeftDownCorner()));
            }
        }else{
            this.setRightUpperCorner(new Position(0,0));
            this.setLeftDownCorner(new Position(0,0));
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
        return new MapVisualizer(this).draw(this.getLeftDownCorner(), this.getRightUpperCorner());
    }

}
