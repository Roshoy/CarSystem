package agh.cs.lab2;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{
    private List<Car> cars  = new LinkedList<Car>();
    private List<HayStack> hayStacks = new LinkedList<HayStack>();

    private Map<Position, Car> carss = new HashMap<Position, Car>();

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

    public boolean place(Car car)throws IllegalAccessException {
        if(isOccupied(car.getPosition())){
            throw new IllegalAccessException("Can't place car on this position " + car.getPosition().toString());
            //return false;
        }
        this.carss.put(car.getPosition(),car);
       // this.cars.add(car);
        return true;
    }

    public void run(LinkedList<MoveDirection> directions) {

        Position[] positions = new Position[carss.keySet().size()];
        carss.keySet().toArray(positions);
        for(int i=0; i<directions.size(); i++){
            //this.cars.get(i%this.cars.size()).move(directions.get(i));
            Car tempCar = carss.get(positions[i%positions.length]);
            carss.remove(positions[i%positions.length]);
            tempCar.move(directions.get(i));
            carss.put(tempCar.getPosition(),tempCar);
            positions[i%positions.length] = tempCar.getPosition();
        }
    }

    public Object objectAt(Position position) {

        if(this.carss.containsKey(position))return carss.get(position);

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

    public List<Car> getCars() {
        return new ArrayList<Car>(carss.values());
        //return cars;
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
