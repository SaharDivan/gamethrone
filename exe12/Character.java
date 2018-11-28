package exe12;

import java.util.Objects;

public class Character {

    private String name;
    private String bookOfDead;
    private String gender;


    public Character(String name, String bookOfDead, String gender) {
        this.name = name;
        this.bookOfDead = bookOfDead;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBookOfDead() {
        return bookOfDead;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return Objects.equals(getName(), character.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBookOfDead(), getGender());
    }

    @Override
    public String toString() {
        return
                name;
    }
}


