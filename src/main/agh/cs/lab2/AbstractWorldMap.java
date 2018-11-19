package agh.cs.lab2;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private List<HayStack> hayStacks = new LinkedList<HayStack>();

    private Map<Position, Car> cars = new HashMap<Position, Car>();

    private Position leftDownCorner;
    private Position rightUpperCorner;



    public abstract boolean canMoveTo(Position position);

    public boolean isOccupied(Position position) {
        if(objectAt(position)!=null)return true;
        return false;
    }

    public boolean placeHayStack(HayStack stack){
        if(isOccupied(stack.getPosition()))return false;
        this.hayStacks.add(stack);
        return true;
    }

    public boolean place(Car car)throws IllegalAccessException {
        if(isOccupied(car.getPosition())){
            throw new IllegalAccessException("Can't place car on this position " + car.getPosition().toString());
            //return false;
        }
        car.addObserver(this);
        this.cars.put(car.getPosition(),car);
       // this.cars.add(car);
        return true;
    }

    public void run(LinkedList<MoveDirection> directions) {

        LinkedList<Car> carList = new LinkedList<>(this.cars.values());
        for(int i=0; i<directions.size(); i++){
            carList.get(i%carList.size()).move(directions.get(i));
        }
    }

    public Object objectAt(Position position) {
        if(this.cars.containsKey(position))return cars.get(position);
        for(HayStack stack: this.hayStacks){
            if(stack.getPosition().equals(position))
                return stack;
        }
        return null;
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        Car tempCar = this.cars.get(oldPosition);
        this.cars.remove(oldPosition);
        this.cars.put(newPosition,tempCar);
    }

    public abstract String toString();

    public List<Car> getCars() {
        return new ArrayList<Car>(cars.values());

    }

    public List<HayStack> getHayStacks() {
        return hayStacks;
    }

    public void setHayStacks(List<HayStack> hayStacks) {
        this.hayStacks = hayStacks;
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
