package model;

/**
 * Created by Abhishek on 12/13/2016.
 */
public class EveningSession extends Session{
    private int eveningSessionTime;
    private int eveningTimeScheduled;

    public EveningSession(int eveningSessionTime) {
        this.eveningSessionTime = eveningSessionTime;
    }

    @Override
    public int getTotalSessionDuration() {
        return eveningSessionTime;
    }

    @Override
    public boolean isSlotAvailable(int minutesToSchedule) {
        if(eveningTimeScheduled + minutesToSchedule <= eveningSessionTime)
            return true;
        else
            return false;
    }

    @Override
    public boolean scheduleSessionSlot(Talks talk) {
        int talkMinutes = talk.getTalkTime();
        eveningTimeScheduled = eveningTimeScheduled + talkMinutes;
        addSessionTalk(talk);
        return true;
    }
}
