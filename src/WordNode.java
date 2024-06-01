import java.util.HashMap;
import java.util.Map;

public class WordNode {

    //The base pairs which a WordNode may contain
    private char[] baseDictionary = new char[]{'A', 'C', 'T', 'G'};
    private char letter;
    private HashMap<Character, WordNode> branches;
    private boolean isEnd;

    //Constructor for nodes that are not at the end
    public WordNode(char letter) {
        this.letter = letter;
        this.isEnd = false;
        this.branches = new HashMap<>();

        //Fills in the HashMap with null values at each letter in our baseDictionary
        for(char c: baseDictionary){
            this.branches.put(c, null);
        }
    }

    public WordNode(char letter, boolean isEnd) {
        this.letter = letter;
        this.isEnd = isEnd;
        this.branches = new HashMap<>();

        //Fills in the HashMap with null values at each letter in our baseDictionary
        for(char c: baseDictionary){
            this.branches.put(c, null);
        }
    }

    public char letter(){
        return this.letter;
    }

    /** Returns a
     * 1 if it is the beginning of a new sequence
     * 0 it is neither the beginning nor end of a new sequence
     * -n if it is the nth sequence ending
     */
    public boolean isEnd(){
        return this.isEnd;
    }
}
