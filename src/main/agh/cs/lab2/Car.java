package agh.cs.lab2;

import java.util.LinkedList;

/**
 * Created by student33 on 2018-10-16.
 */
//Adrian
public class Car implements IMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private Position position  = new Position(2,2);
    private LinkedList<IPositionChangeObserver> observers = new LinkedList<>();
   /* public void Car(){
        this.direction = MapDirection.NORTH;
        this.position = new Position(2,2);
    }*/
    private IWorldMap map;
    public Car(IWorldMap map, Position initialPosition){
        this.map = map;

        this.position = initialPosition;
    }
    public Car(IWorldMap map){
        this.map = map;
        this.position = new Position(0,0);
    }

    public void move (MoveDirection direction){
        Position newPosition = this.position;
        switch (direction){
            case RIGHT:
                this.direction = this.direction.next(this.direction);
                break;
            case LEFT:
                this.direction = this.direction.previous(this.direction);
                break;
            case FORWARD:
                newPosition = newPosition.add(this.direction.toVector());
                break;
            case BACKWARD:
                newPosition = newPosition.add(this.direction.toVector().multiply(-1));
                break;
        }
    //    if(newPosition.smallerThan(new Position(4, 4)) && newPosition.largerThan(new Position(0, 0))){
    //        this.position = newPosition;
    //    }
        if(map.canMoveTo(newPosition)){
            this.position = newPosition;
        }

    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Position newPosition){
        for(IPositionChangeObserver observer : this.observers){
            observer.positionChanged(this.position,newPosition);
        }
    }

    public Position getPosition(){
        return this.position;
    }

    public String dataToString(){
        return this.direction.toString() + " " + this.position.toString();
    }

    public String toString(){
        return this.direction.toString();
    }


}
