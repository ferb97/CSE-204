public class Dish {
    private Integer number;
    private Integer washingTime;

    Dish(Integer number, Integer washingTime){
        this.number = number;
        this.washingTime = washingTime;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public void setWashingTime(Integer washingTime){
        this.washingTime = washingTime;
    }

    public int getNumber() {
        return number;
    }

    public int getWashingTime() {
        return washingTime;
    }
}
