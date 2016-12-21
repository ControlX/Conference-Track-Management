package model;

/**
 * Created by Abhishek on 12/13/2016.
 */
public class MorningSession extends Session{

    private int morningSessionTime;
    private int morningTimeScheduled;

    public MorningSession(int morningSessionTime) {
        this.morningSessionTime = morningSessionTime;
    }

    @Override
    public int getTotalSessionDuration() {
        return morningSessionTime;
    }

    @Override
    public boolean isSlotAvailable(int minutesToSchedule) {
        if(morningTimeScheduled + minutesToSchedule <= morningSessionTime)
            return true;
        else
            return false;
    }

    @Override
    public boolean scheduleSessionSlot(Talks talk) {
        int talkMinutes = talk.getTalkTime();
        morningTimeScheduled = morningTimeScheduled + talkMinutes;
        addSessionTalk(talk);
        return true;
    }
}
