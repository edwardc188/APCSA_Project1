public class Crystal {
    private int weight = 500;
    private int value = 0;

    public Crystal (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    public int getOdds() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public int mine() {
        if ((int) (Math.random()*1000) > weight) {
            return value;
        }
        return -1;
    }
}
