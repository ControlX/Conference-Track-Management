package model;

import java.util.ArrayList;

/**
 * Created by Abhishek on 12/12/2016.
 */
public abstract class Session {
    private ArrayList<Talks> sessionList;

    public ArrayList<Talks> getSessionList(){
        return sessionList;
    }

    public void addSessionTalk(Talks talk) {
        if(sessionList == null)
            sessionList = new ArrayList<>();

        this.sessionList.add(talk);
    }

    public abstract int getTotalSessionDuration();

    public abstract boolean isSlotAvailable(int minutesToSchedule);

    public abstract boolean scheduleSessionSlot(Talks talk);
}
