import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class WordNode {

    //The base pairs which a WordNode may contain
    private NucleotideSet nucleotides = new NucleotideSet();
    private char letter;
    private HashMap<Character, WordNode> branches;
    private int modifier;

    //Constructor for nodes that are not at the end
    public WordNode(char letter) {

        //Make sure letter is valid
        if (!nucleotides.getNucleotides().contains(letter)){
            throw new IllegalArgumentException("Letter given is not a valid nucleotide");
        }

        this.letter = letter;
        this.modifier = -1;
        this.branches = new HashMap<>();

        //Fills in the HashMap with null values at each letter in our baseDictionary
        for(char c: nucleotides.getNucleotides()){
            this.branches.put(c, null);
        }
    }

    public WordNode(char letter, boolean isEnd) {

        //Make sure letter is valid
        if (!nucleotides.getNucleotides().contains(letter)){
            throw new IllegalArgumentException("Letter given is not a valid nucleotide");
        }
        this.letter = letter;
        if (isEnd){
            this.modifier = 1;
        } else {
            this.modifier = -1;
        }
        this.branches = new HashMap<>();

        //Fills in the HashMap with null values at each letter in our baseDictionary
        for(char c: nucleotides.getNucleotides()){
            this.branches.put(c, null);
        }
    }

    //Attaches a given node
    public void attachNode(WordNode base){
        char letter = base.getLetter();
        if (letter == 'A'){
            this.branches.put('A', base);
        } else if (letter == 'C'){
            this.branches.put('C', base);
        }
        else if (letter == 'T'){
            this.branches.put('T', base);
        } else {
            this.branches.put('G', base);
        }
    }

    public char getLetter(){
        return this.letter;
    }

    public HashMap<Character, WordNode> getBranches(){
        return this.branches;
    }

    //Returns true if the wordNode is the end of a sequence
    public boolean isEnd(){
        return (this.modifier > 0);
    }

    //Adds one to the modifier
    public void increase(){
        this.modifier += 1;
    }

    public void changeToEnd(){
        this.modifier = 1;
    }
}
