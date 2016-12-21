package manager;

import enums.EnumSessionSlot;
import helper.Constants;
import helper.Utils;
import model.*;

import java.util.ArrayList;

/**
 * Created by Abhishek on 12/13/2016.
 */
public class SessionManagement {
    private Session morningSession, eveningSession;
    private Track sessionTrack;

    public SessionManagement() {
        morningSession = new MorningSession(Constants.MORNING_SESSION_MAX_TIME);
        eveningSession = new EveningSession(Constants.EVENING_SESSION_MAX_TIME);
        sessionTrack = new Track();
    }

    public boolean scheduleSessionSlot(EnumSessionSlot enumSessionSlot, Talks talk) {
        switch (enumSessionSlot){
            case MORNING:
                morningSession.scheduleSessionSlot(talk);
                return true;
            case EVENING:
                eveningSession.scheduleSessionSlot(talk);
                return true;
            default:
                return false;
        }
    }

    public EnumSessionSlot isTimeSlotAvailable(int minutesToSchedule) {
        if (morningSession.isSlotAvailable(minutesToSchedule))
            return EnumSessionSlot.MORNING;
        else if (eveningSession.isSlotAvailable(minutesToSchedule))
            return EnumSessionSlot.EVENING;
        else
            return EnumSessionSlot.NOTFREE;

    }

    public String getSessionTrack() {
        return sessionTrack.getSessionTrackList();
    }

    public void createSessionTrack(){
        sessionTrack.setSessionTrackList(processTrackForUser());
    }

    private String processTrackForUser(){
        StringBuilder builder = new StringBuilder();
        ArrayList<Talks> morningScheduledSessionList = morningSession.getSessionList();
        ArrayList<Talks> eveningScheduledSessionList = eveningSession.getSessionList();

        //Morning Session
        String morningStartTime = Constants.MORNING_SESSION_START_TIME;
        int timeScheduledForTalk = 0;
        for (int i = 0; i < morningScheduledSessionList.size(); i++) {
            morningStartTime = Utils.getTime(morningStartTime, timeScheduledForTalk);
            builder.append(morningStartTime+" "+morningScheduledSessionList.get(i).getTalkName());
            builder.append("\n");
            timeScheduledForTalk = morningScheduledSessionList.get(i).getTalkTime();
        }

        //Lunch Time
        builder.append(Utils.getTime(Constants.LUNCH_START_TIME, 0)+Constants.LUNCH);
        builder.append("\n");

        //Evening Session
        String eveningStartTime = Constants.EVENTING_SESSION_START_TIME;
        timeScheduledForTalk = 0;
        for (int i = 0; i < eveningScheduledSessionList.size(); i++) {
            eveningStartTime = Utils.getTime(eveningStartTime, timeScheduledForTalk);
            builder.append(eveningStartTime+" "+eveningScheduledSessionList.get(i).getTalkName());
            builder.append("\n");
            timeScheduledForTalk = eveningScheduledSessionList.get(i).getTalkTime();
        }

        //Networking Event
        builder.append(Utils.getTime(eveningStartTime, timeScheduledForTalk)+Constants.NETWORK_EVENT);

        return builder.toString();
    }
}
