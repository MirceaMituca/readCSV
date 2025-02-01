package org.example;


public enum ShootingRangeResult {

    HIT("x", 0), MISS("o", 10);

    private final String value;
    private final int penalty;

    ShootingRangeResult(String value, int penalty) {
        this.value = value;
        this.penalty = penalty;
    }

    public String getValue() {
        return value;
    }

    public int getPenalty() {
        return penalty;
    }

    public static ShootingRangeResult fromString(String m){
        for (ShootingRangeResult result : values()){
            if(result.value.equals(m)){
                return result;
            }
        }
            throw new IllegalArgumentException("This is not a valid shot");
    }
}