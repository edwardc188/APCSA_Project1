import java.util.ArrayList;

public class Cave {
    private int numCrystals;
    private ArrayList<Crystal> crystals = new ArrayList<>();

    public Cave(int numCrystals) {
        this.numCrystals = numCrystals;
        for (int i = 0; i < numCrystals; i++) {
            int seed = (int) (Math.random() * 1000);
            // value of crystal is dependent on the chance of success
            crystals.add(new Crystal(seed, (int) (Math.pow(seed / 10.0, (Math.random() * 0.5 + 1.25)))));
        }
    }

    public int getNumCrystals() {
        return numCrystals;
    }

    public ArrayList<Crystal> getCrystals() {
        return crystals;
    }
}
