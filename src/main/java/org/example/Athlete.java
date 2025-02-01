package org.example;

public class Athlete implements Comparable<Athlete>{
    private int number;
    private String name;
    private String country;
    private int skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public Athlete(int number, String name, String country, int skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(int skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    private int calculateTotalPenalty(String range){
        int totalPenalty = 0;
        char[] shots = range.toCharArray();
        for (char c : shots){
            ShootingRangeResult result = ShootingRangeResult.fromString(String.valueOf(c));
            totalPenalty += result.getPenalty();
        }
        return totalPenalty;
    }

    public int finalTime(){
        return skiTimeResult
                +calculateTotalPenalty(firstShootingRange)
                +calculateTotalPenalty(secondShootingRange)
                +calculateTotalPenalty(thirdShootingRange);
    }

    @Override
    public int compareTo(Athlete other){
        return Integer.compare(this.finalTime(), other.finalTime());
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", skiTimeResult=" + skiTimeResult +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }
}
