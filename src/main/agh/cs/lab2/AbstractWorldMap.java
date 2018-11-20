package agh.cs.lab2;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private List<HayStack> hayStacks = new LinkedList<HayStack>();

    private Map<Position, Car> cars = new HashMap<Position, Car>();

    private Map<Position,IMapElement>  mapElements = new HashMap<>();

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

    public boolean place(IMapElement element)throws IllegalAccessException {
        if(isOccupied(element.getPosition())){
            throw new IllegalAccessException("Can't place element on this position " + element.getPosition().toString());
        }
        if(element instanceof Car){
            ((Car) element).addObserver(this);
        }
        this.mapElements.put(element.getPosition(), element);
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
        for(IMapElement element: this.mapElements.values()){
            if(element instanceof Car)carList.add((Car)element);
        }

        for(int i=0; i<directions.size(); i++){
            carList.get(i%carList.size()).move(directions.get(i));
        }
    }

    public Object objectAt(Position position) {

       // if(this.cars.containsKey(position))return cars.get(position);
        if(this.mapElements.containsKey(position))return this.mapElements.get(position);
//        for(HayStack stack: this.hayStacks){
//            if(stack.getPosition().equals(position))
//                return stack;
//        }
        return null;
    }

    public void positionChanged(Position oldPosition, Position newPosition){
//        Car tempCar = this.cars.get(oldPosition);
       // this.cars.remove(oldPosition);
        this.cars.put(newPosition,this.cars.remove(oldPosition));
    }

    public abstract String toString();

    public List<Car> getCars() {
        //return new ArrayList<Car>(cars.values());
        ArrayList<Car> carList= new ArrayList<Car>();
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
