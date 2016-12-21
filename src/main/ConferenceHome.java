package main;

import helper.Constants;
import manager.ConferenceManagement;
import model.Talks;

import java.util.ArrayList;

/**
 * Created by Abhishek on 12/12/2016.
 */
public class ConferenceHome {

    public static void main(String[] args) {
        ConferenceManagement conferenceManagement = new ConferenceManagement();

        //Unscheduled
        ArrayList<Talks> confUnscheduledList = conferenceManagement.createDataStructureForConfSchedule();
        //Sorted Unscheduled
        conferenceManagement.prioritiseBigTimeSlots(true, confUnscheduledList);

        //Create Schedule for the List and tell the status to user whether it is Scheduled or Not Scheduled
        for (Talks talks : confUnscheduledList) {
            boolean status = conferenceManagement.scheduleSessionSlot(talks);
            if (status)
                System.out.println(talks.getTalkName() + Constants.SCHEDULE_SUCCESSFUL);
            else
                System.out.println(talks.getTalkName() + Constants.SCHEDULE_UNSUCCESFUL);
        }

        // Create Track for list
        conferenceManagement.processSessionTrackList();

        // Dummy spacing
        System.out.println("\n\n");

        // Show Conference Tack List
        System.out.println(conferenceManagement.getSessionTrackList());
    }
}