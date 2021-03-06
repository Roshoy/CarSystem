package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    private List<Car> cars  = new LinkedList<Car>();
    private List<HayStack> hayStacks = new LinkedList<HayStack>();

    private Position leftDownCorner;
    private Position rightUpperCorner;



    public boolean canMoveTo(Position position){

        if( this.rightUpperCorner.largerThan(position) &&
            this.leftDownCorner.smallerThan(position) &&
            !isOccupied(position))return true;
        return false;
    }

    public boolean isOccupied(Position position) {
        if(objectAt(position)!=null)return true;
        return false;
    }

    public boolean placeHayStack(HayStack stack){
        if(isOccupied(stack.getPosition()))return false;
        this.hayStacks.add(stack);
        return true;
    }

    public boolean place(Car car) {
        if(isOccupied(car.getPosition()))return false;
        this.cars.add(car);
        return true;
    }

    public void run(LinkedList<MoveDirection> directions) {
        for(int i=0; i<directions.size(); i++){
            this.cars.get(i%this.cars.size()).move(directions.get(i));
        }
    }

    public Object objectAt(Position position) {
        for(Car car: this.cars){
            if(car.getPosition().equals(position))
                return car;
        }
        for(HayStack stack: this.hayStacks){
            if(stack.getPosition().equals(position))
                return stack;
        }
        return null;
    }

    public abstract String toString();

    public Car getCar(int i){
        return cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
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
