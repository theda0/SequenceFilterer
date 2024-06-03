import java.util.HashSet;
import java.util.Set;

public class NucleotideSet {
    // Declare the private HashSet variable
    private Set<Character> nucleotides;

    // Constructor to initialize the HashSet
    public NucleotideSet() {

        //The characters that we wish to appear in our nucleotide set
        char[] chars = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        nucleotides = new HashSet<>();
        for (char c : chars) {
            nucleotides.add(c);
        }
    }

    // Getter method to access the nucleotides
    public Set<Character> getNucleotides() {
        return nucleotides;
    }

}
