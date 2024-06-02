public class StringSplitter {

    public static String[] StringSplit(String input, int chunkSize){
        int length = input.length();
        int numOfChunks = (int) Math.ceil((double) length / chunkSize);

        String[] chunks = new String[numOfChunks];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, length);
            chunks[i] = input.substring(start, end);
        }

        return chunks;
    }
}
