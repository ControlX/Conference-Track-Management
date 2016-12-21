package model;

/**
 * Created by Abhishek on 12/12/2016.
 */
public class Talks  implements Comparable{
    private String talkName;
    private int talkTime;

    public Talks(String talkName, int talkTime){
        this.talkName = talkName;
        this.talkTime = talkTime;
    }

    public String getTalkName() {
        return talkName;
    }

    public int getTalkTime() {
        return talkTime;
    }

    @Override
    public int compareTo(Object o) {
        int compareTime =((Talks)o).getTalkTime();
        return compareTime - this.talkTime;
    }
}
