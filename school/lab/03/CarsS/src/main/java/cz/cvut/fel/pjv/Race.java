package cz.cvut.fel.pjv;

import cz.cvut.fel.pjv.data.CarLinkedList;
import cz.cvut.fel.pjv.data.RaceResult;
import cz.cvut.fel.pjv.data.TimeSpan;
import cz.cvut.fel.pjv.model.Car;

public class Race {
    private int length;
    private CarLinkedList cll;
    private boolean raceStarted;
    private RaceResult[] raceResults;

    public Race( int length ) {
        this.length = length;
        raceStarted = false;
        cll = new CarLinkedList();
    }

    public boolean addRacingCar( Car car ) {
        if ( raceStarted ) {
            return false;
        }
        cll.add( car );
        return true;
    }

    public Car getWinner() {
        calculateResults();
        return raceResults[0].getCar();
    }

    public TimeSpan getWinningTime() {
        calculateResults();
        return raceResults[0].getTs();
    }

    private void calculateResults() {}

}
