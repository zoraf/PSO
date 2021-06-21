public class Swarm {

    private double x;
    private double y;
    private double bestKnownX;

    public Swarm() {
    }

    public Swarm(double x, double y, double bestKnownX) {
        this.x = x;
        this.y = y;
        this.bestKnownX = bestKnownX;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getBestKnownX() {
        return bestKnownX;
    }

    public void setBestKnownX(double bestKnownX) {
        this.bestKnownX = bestKnownX;
    }

}
