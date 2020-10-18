package handlers.FRC;

import handlers.Handler;
import util.Message;

public class MatchPredictor implements Handler {
    private ScoutingData data;
    public MatchPredictor() {
        this.data = new ScoutingData();
    }

    @Override
    public void handleMessage(Message m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
        
    }

    public Result simulateOne(Match m) {
        int i = 0; 
        int blueScore = 0;
        int redScore = 0;
        while(i<3){
            if(data.isPlayingMatch(m.getBlueAlliance()[i]) && !data.isPlayingDefense(m.getBlueAlliance()[i])){
                blueScore = blueScore + data.getPossibleScore(m.getBlueAlliance()[i]);
            }
            if(data.isPlayingMatch(m.getRedAlliance()[i]) && !data.isPlayingDefense(m.getRedAlliance()[i])){
                redScore = redScore + data.getPossibleScore(m.getRedAlliance()[i]);
            }
            i++;
        }
        if(redScore<blueScore){
            return Result.BLUE_WIN;
        } else if (redScore>blueScore){
            return Result.RED_WIN;
        } else {
            return Result.TIE;
        }
    }

    public Prediction simulateMany(Match m) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED");
    }
}