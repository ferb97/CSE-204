public class PersonTime {
    private int person;
    private int time;

    PersonTime(int person, int time){
        this.person = person;
        this.time = time;
    }

    public void setPerson(int person){
        this.person = person;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getPerson(){
        return this.person;
    }

    public int getTime(){
        return this.time;
    }
}
