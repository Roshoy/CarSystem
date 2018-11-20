package agh.cs.lab2;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    private Map<Position, IMapElement> mapElements = new HashMap<>();

    private Position leftDownCorner;
    private Position rightUpperCorner;

    public abstract boolean canMoveTo(Position position);

    public boolean isOccupied(Position position) {
        if (objectAt(position) != null) return true;
        return false;
    }

    public boolean place(IMapElement element) throws IllegalAccessException {
        if (isOccupied(element.getPosition())) {
            throw new IllegalAccessException("Can't place element on this position " + element.getPosition().toString());
        }
        if (element instanceof Car) {
            ((Car) element).addObserver(this);
        }
        this.mapElements.put(element.getPosition(), element);
        return true;
    }

    public void run(LinkedList<MoveDirection> directions) {

        LinkedList<Car> carList = new LinkedList<>();
        for(IMapElement element: this.mapElements.values()){
            if(element instanceof Car)carList.add((Car)element);
        }

        for(int i=0; i<directions.size(); i++){
            carList.get(i%carList.size()).move(directions.get(i));
        }
    }

    public Object objectAt(Position position) {
        if(this.mapElements.containsKey(position))return this.mapElements.get(position);

        return null;
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        this.mapElements.put(newPosition,this.mapElements.remove(oldPosition));
    }

    public abstract String toString();

    public List<Car> getCars() {
        ArrayList<Car> carList= new ArrayList<>();
        for(IMapElement element: this.mapElements.values()){
            if(element instanceof Car)carList.add((Car)element);
        }
        return carList;
    }

    public List<HayStack> getHayStacks() {
        ArrayList<HayStack> hayStackList= new ArrayList<>();
        for(IMapElement element: this.mapElements.values()){
            if(element instanceof HayStack)hayStackList.add((HayStack) element);
        }
        return hayStackList;
    }

    public Position getLeftDownCorner() {
        return leftDownCorner;
    }

    public void setLeftDownCorner(Position leftDownCorner) {
        this.leftDownCorner = leftDownCorner;
    }

    public Position getRightUpperCorner() {
        return rightUpperCorner;
    }

    public void setRightUpperCorner(Position rightUpperCorner) {
        this.rightUpperCorner = rightUpperCorner;
    }
}
