package sweeper;

public class Flag {
     private Matrix flagMap;
    private int countOfCLosedBoxes;
     void start() {
         flagMap = new Matrix(Box.CLOSED);
        countOfCLosedBoxes = Ranges.getSize().x * Ranges.getSize().y;

     }

     Box get(Coord coord) {
         return flagMap.get(coord);
     }
     public void setOpenedToBox(Coord coord) {
         flagMap.set(coord, Box.OPENED);
         countOfCLosedBoxes--;
     }
     private void setFlagedToBox(Coord coord) {
         flagMap.set(coord, Box.FLAGED);
     }
     public void toggleFlagedToBox(Coord coord) {
         switch (flagMap.get(coord)) {
             case FLAGED: setClosedToBox(coord); break;
             case CLOSED: setFlagedToBox(coord); break;
         }
     }
     public void setClosedToBox(Coord coord) {
         flagMap.set(coord, Box.CLOSED);
     }

    public int getCountOfCLosedBoxes() {
         return countOfCLosedBoxes;
    }
    public void setBombedToBox(Coord coord) {
         flagMap.set(coord, Box.BOMBED);
    }

    public void setOpenedToClosedBombBox(Coord coord) {
         if (flagMap.get(coord) == Box.CLOSED) {
             flagMap.set(coord, Box.OPENED);
         }
    }

    public void setNoBombToFlagedSafeBox(Coord coord) {
         if (flagMap.get(coord) == Box.FLAGED)
             flagMap.set(coord, Box.NOBOMB);
    }

    public int getCountOfFlagedBoxesAround(Coord coord) {
        int count = 0;
        for (Coord around : Ranges.getCoordsAround(coord)) {
            if (flagMap.get(around) == Box.FLAGED)
                count++;
        }
        return count;
    }
}

