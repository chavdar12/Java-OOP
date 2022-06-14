package MordorCrueltyPlan;

public class Gandalf {
    private int foodPoints;

    public Gandalf() {
    }

    public void eatFood(String food) {
        switch (food.toLowerCase()) {
            case "cram" -> foodPoints += 2;
            case "lembas" -> foodPoints += 3;
            case "apple", "melon" -> foodPoints += 1;
            case "honeycake" -> foodPoints += 5;
            case "mushrooms" -> foodPoints -= 10;
            default -> foodPoints -= 1;
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }

    public String getMood() {
        if (this.foodPoints < -5) {
            return "Angry";
        } else if (this.foodPoints < 0) {
            return "Sad";
        } else if (this.foodPoints < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }
}
