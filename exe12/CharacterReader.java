package exe12;

import exe9.FileReader;

import java.util.ArrayList;
import java.util.List;

public class CharacterReader {

    private FileReader reader=new FileReader();


    public List<Character> getCharacter(String filepath){

        List<String> lines = reader.asLine(filepath);
        return makeCharacters(lines);
    }

    private List<Character> makeCharacters( List<String> lines) {
        List<Character> characters=new ArrayList<>();
        lines.remove(0);

        for (String line:lines) {
            Character character=makeOneCharacter(line);
            characters.add(character);
        }
        return characters;
    }

    private Character makeOneCharacter(String line) {

        String[] splited = line.split(";");
        String name=splited[0];
        String bookOfDead=splited[3];
        String gender=splited[6];
        Character character=new Character(name,bookOfDead,gender);
        return character;
    }
}
