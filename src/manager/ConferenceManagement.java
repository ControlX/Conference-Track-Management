package manager;

import enums.EnumSessionSlot;
import helper.Constants;
import model.Talks;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Abhishek on 12/12/2016.
 */
public class ConferenceManagement {
    private SessionManagement sessionManagement;

    public ConferenceManagement(){
        sessionManagement = new SessionManagement();
    }

    public boolean scheduleSessionSlot(Talks talk){
        EnumSessionSlot enumSessionSlot = sessionManagement.isTimeSlotAvailable(talk.getTalkTime());

        if(enumSessionSlot == EnumSessionSlot.NOTFREE)
            return false;
        else
            return sessionManagement.scheduleSessionSlot(enumSessionSlot, talk);
    }

    public void processSessionTrackList(){
        sessionManagement.createSessionTrack();
    }

    public String getSessionTrackList(){
        return sessionManagement.getSessionTrack();
    }

    public ArrayList<Talks> createDataStructureForConfSchedule(){
        ArrayList<Talks> talksList = new ArrayList<>();
        String[] conferenceSchedule = Constants.conferenceInput;
        int size = conferenceSchedule.length;

        for (int i = 0; i < size; i++) {
            if (conferenceSchedule[i].endsWith(Constants.LIGHTNING)) {
                talksList.add(new Talks(conferenceSchedule[i], Constants.LIGHTNING_VALUE));
            } else {
                String minutesExtracted = conferenceSchedule[i].replaceAll(Constants.REGEX_GET_NUMBER, "");
                int extractedMinutes;
                try {
                    extractedMinutes = Integer.parseInt(minutesExtracted);
                    if (extractedMinutes != 0) {
                        talksList.add(new Talks(conferenceSchedule[i], extractedMinutes));
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return talksList;
    }

    public void prioritiseBigTimeSlots(boolean isPriorityRequired, ArrayList<Talks> talksList){
        if(isPriorityRequired)
            Collections.sort(talksList);
    }
}
