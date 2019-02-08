public enum PlaneType {
    BOEING747(524, 333400, 50),
    BOEING737(215, 70535, 40),
    AIRBUSA320(186, 83000, 30),
    AIRBUSA380(853, 560000, 55);

    private final int capacity;
    private final int weight;
    private final int weightPerBag;

    PlaneType(int capacity, int weight, int weightPerBag){
        this.capacity = capacity;
        this.weight = weight;
        this.weightPerBag = weightPerBag;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    public int getWeightPerBag() {
        return weightPerBag;
    }
}
