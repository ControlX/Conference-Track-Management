package helper;

/**
 * Created by Abhishek on 12/12/2016.
 */
public interface Constants {
    String[] conferenceInput =
            {
                    "Writing Fast Tests 60min",
                    "Overdoing it in Python 45min",
                    "Lua for the masses 30min",
                    "Ruby for the masses 45min",
                    "Common ruby errors",
                    "Rails for Python developers lightning",
                    "Communicating over distance 60min",
                    "Account driven development 45min",
                    "Woah 30min",
                    "Sit down and write 30min",
                    "Pair programming vs noise 45min",
                    "Rails magic 60min",
                    "Ruby on Rails: Why we should we should move on 60min",
                    "Clojure ate scala 45min",
                    "Programming in the Boondocks of Seattle 30min",
                    "Ruby vs Clojure for backend development 30min",
                    "Ruby on Rails legacy app maintenance 60min",
                    "A world without hacker news 30min",
                    "User interface CSS in Rails Apps 30min"
            };

    String LIGHTNING = "lightning";
    int LIGHTNING_VALUE = 5;
    String REGEX_GET_NUMBER = "[^0-9]";
    int MORNING_SESSION_MAX_TIME = 180;
    int EVENING_SESSION_MAX_TIME = 240;
    String SCHEDULE_SUCCESSFUL = "\t-> scheduled successfully";
    String SCHEDULE_UNSUCCESFUL = "\t-> schedule not available";
    String LUNCH = " Lunch";
    int LUNCH_DURATION = 60;
    String NETWORK_EVENT = " Network Event";
    int NETWORK_EVENT_DURATION = 60;
    String MORNING_SESSION_START_TIME = "09:00";
    String LUNCH_START_TIME = "12:00";
    String EVENTING_SESSION_START_TIME = "13:00";
}
