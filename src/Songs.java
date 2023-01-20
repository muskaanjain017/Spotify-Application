public class Songs {
    private String name;
    private double duration;

    public Songs(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
