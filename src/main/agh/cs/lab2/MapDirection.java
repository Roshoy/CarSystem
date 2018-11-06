package agh.cs.lab2;

/**
 * Created by student34 on 2018-10-09.
 */
public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        switch(this){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            case EAST:
                return "E";
        }
        return "NON";
    }
    public MapDirection next(MapDirection dir){
        switch(dir){
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
        }
        return dir;
    }
    public MapDirection previous(MapDirection dir){
        switch(dir){
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
        }
        return dir;
    }

    public Position toVector(){
        switch(this){
            case NORTH:
                return new Position(0,1);
            case SOUTH:
                return new Position(0,-1);
            case WEST:
                return new Position(-1,0);
            case EAST:
                return new Position(1,0);
        }

        return new Position(0,0);
    }

}
