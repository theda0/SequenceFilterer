import java.util.HashSet;
import java.util.Set;

public class NucleotideSet {
    // Declare the private HashSet variable
    private Set<Character> nucleotides;

    // Constructor to initialize the HashSet
    public NucleotideSet() {
        nucleotides = new HashSet<>();
        nucleotides.add('A');
        nucleotides.add('T');
        nucleotides.add('C');
        nucleotides.add('G');
        nucleotides.add('S'); //?
        nucleotides.add('M'); //?
    }

    // Getter method to access the nucleotides
    public Set<Character> getNucleotides() {
        return nucleotides;
    }

}
