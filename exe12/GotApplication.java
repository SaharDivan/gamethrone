package exe12;

import java.util.*;

public class GotApplication {

    public static void main(String[] args) {
        CharacterReader reader=new CharacterReader();
        List<Character> characterList = reader.getCharacter("exe12/get-characters.csv");

        displayTotalNumberOfCharacters(characterList);
        List<Character> deadCharacters=findTotalNumberOfDeadCharacters(characterList);
        displayPercentageOfDeadMen(deadCharacters);
        displayPercentageOfDeadWomen(deadCharacters);
        Map<String,List<Character>> deadBook=displayTheListOfDeadsPerBook(characterList,deadCharacters);
        displayTheHighestDeadToll(deadBook);
    }

    private static void displayTotalNumberOfCharacters(List<Character> characterList) {
        System.out.println("The total number of characters in all books is: "+ characterList.size());
    }

    private static List<Character> findTotalNumberOfDeadCharacters(List<Character> characterList) {
        List<Character> deadCharacters=new ArrayList<>();
        for (Character character:characterList) {
            if(!character.getBookOfDead().isEmpty()){
                deadCharacters.add(character);
            }
        }
        System.out.println("The total number of dead characters in all books is: "+ deadCharacters.size());
        return deadCharacters;
    }

    private static void displayPercentageOfDeadMen(List<Character> deadCharacters) {

        Integer totalDead=deadCharacters.size();
        Integer deadMen=0;
        for (Character deadCharacter: deadCharacters) {
            if(deadCharacter.getGender().equals("1")){
               deadMen=deadMen+1;
            }
        }
        Integer percentage=deadMen*100/totalDead;
        System.out.println("With "+deadMen+" dead,the percentage of male dead toll is: "+percentage+"%");
    }

    private static void displayPercentageOfDeadWomen(List<Character> deadCharacters) {

        Integer totalDead=deadCharacters.size();
        Integer deadWomen=0;
        for (Character deadCharacter: deadCharacters) {
            if(deadCharacter.getGender().equals("0")){
                deadWomen+=1;
            }
        }
        Integer percentage=deadWomen*100/totalDead;
        System.out.println("With "+deadWomen+" dead the percentage of female dead toll is: "+percentage+ "%");
    }

    private static Map<String,List<Character>> displayTheListOfDeadsPerBook(List<Character> characterList, List<Character> deadCharacters) {
        Map<String,List<Character>> deadBook= findDeadMap(characterList,characterList);
        displayTheListInOrder(deadBook);
        return deadBook;
    }

    private static Map<String,List<Character>> findDeadMap(List<Character> characterList, List<Character> deadCharacters) {
        Map<String,List<Character>> deadBook= makeTheEmptyMap(characterList);
        deadBook=fillTheMapWithDead(deadBook,deadCharacters);
        return deadBook;
    }

    private static Map<String, List<Character>> makeTheEmptyMap(List<Character> characterList) {
        Map<String,List<Character>> deadBook=new HashMap<>();
        for (Character character:characterList) {
            if(!character.getBookOfDead().isEmpty())
            deadBook.put(character.getBookOfDead(),new ArrayList());
        }
        return deadBook;
    }

    private static Map<String,List<Character>> fillTheMapWithDead(Map<String, List<Character>> deadBook, List<Character> deadCharacters) {
        for (Character deadCharacter:deadCharacters) {
            if(deadCharacter.getBookOfDead().equals("1")){deadBook.get("1").add(deadCharacter);}
            if(deadCharacter.getBookOfDead().equals("2")){deadBook.get("2").add(deadCharacter);}
            if(deadCharacter.getBookOfDead().equals("3")){deadBook.get("3").add(deadCharacter);}
            if(deadCharacter.getBookOfDead().equals("4")){deadBook.get("4").add(deadCharacter);}
            if(deadCharacter.getBookOfDead().equals("5")){deadBook.get("5").add(deadCharacter);}
        }
        return deadBook;
    }

    private static List<DeadPerBook> displayTheListInOrder(Map<String, List<Character>> deadBook) {
        List<DeadPerBook> deadToll = new ArrayList<>();
        Set<String> bookSet = deadBook.keySet();
        for (String book : bookSet) {
            DeadPerBook deadPerBook = new DeadPerBook(book, deadBook.get(book).size());
            deadToll.add(deadPerBook);
        }
        deadToll.sort(Comparator.comparing(DeadPerBook::getDeadToll).reversed());
        for (DeadPerBook dead : deadToll) {
            System.out.println("The Book " + dead.getName() + " has the rank " + " in dead toll with number of: " + dead.getDeadToll());
        }
        return deadToll;
    }


    private static void displayTheHighestDeadToll(Map<String, List<Character>> deadBook) {
        List<DeadPerBook> deadToll=displayTheListInOrder(deadBook);
        System.out.println("The highest dead toll is in book :"+deadToll.get(0).getName()+" with "+
                deadToll.get(0).getDeadToll());
        System.out.println("Names of People died in Book 3:"+deadBook.get(deadToll.get(0).getName()));
    }
}
