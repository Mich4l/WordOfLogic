public class Counter implements Comparable {

    public String character;
    public int wordSize;
    public int howManyCharactersFind;

    public Counter(String character, int wordSize, int howManyCharactersFind) {
        this.character = character;
        this.wordSize = wordSize;
        this.howManyCharactersFind = howManyCharactersFind;
    }

    @Override
    public int compareTo(Object o) {
        int comparehowManyCharactersFind=((Counter)o).getHowManyCharactersFind();
        return this.howManyCharactersFind-comparehowManyCharactersFind;
    }


    public int getHowManyCharactersFind() {
        return howManyCharactersFind;
    }

}
