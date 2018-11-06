package agh.cs.lab2;

import java.util.LinkedList;

/**
 * Created by student33 on 2018-10-16.
 */
public class OptionsParser {
    public static LinkedList<MoveDirection> parse(String[] args)throws IllegalArgumentException {
        LinkedList<MoveDirection> result = new LinkedList<MoveDirection>();
        for(String s : args){
            switch (s){
                case "f":
                case "forward":
                    result.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    result.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                case "left":
                    result.add(MoveDirection.LEFT);
                    break;
                case "r":
                case "right":
                    result.add(MoveDirection.RIGHT);
                    break;
                default:
                    throw new IllegalArgumentException(s + " is not legal move specification");
            }
        }
        return result;
    }

}
