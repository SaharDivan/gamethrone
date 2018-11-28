package exe12;

import java.util.Objects;

public class DeadPerBook {

    private String name;
    private Integer deadToll;


    public DeadPerBook(String name, Integer deadToll) {
        this.name = name;
        this.deadToll = deadToll;
    }

    public String getName() {
        return name;
    }

    public Integer getDeadToll() {
        return deadToll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeadPerBook)) return false;
        DeadPerBook that = (DeadPerBook) o;
        return Objects.equals(getDeadToll(), that.getDeadToll());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDeadToll());
    }

    @Override
    public String toString() {
        return "DeadPerBook{" +
                "name='" + name + '\'' +
                ", deadToll=" + deadToll +
                '}';
    }
}
