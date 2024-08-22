public class WordScrambler {
    private String[] scrambledWords;
    public WordScrambler(String[] words) {
        if (words.length % 2 == 1) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        if (!(checkValid(words))) {
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        scrambledWords = mixedWords(words);
    }
    private String recombine(String word1, String word2) {
        String out = "";
        if (word1.length() % 2 ==0) {
            out = out + word1.substring(0, word1.length() / 2);
        }
        else {
            out = out + word1.substring(0, (word1.length()-1) / 2);
        }
        if (word2.length() % 2 ==0) {
            out = out + word2.substring(word2.length()/2);
        }
        else {
            out = out + word2.substring((word2.length()-1) / 2);
        }
        return out;
    }

    private String[] mixedWords(String[] words) {
        String[] temp = new String[words.length];
        for (int i = 0; i < words.length; i = i+2) {
            temp[i] = recombine(words[i], words[i+1]);
            temp[i+1] = recombine(words[i+1], words[i]);
        }
        return temp;
    }
    public String[] getScrambledWords() {
        return scrambledWords;
    }
    private boolean checkValid(String[] word) {
        for (String s : word) {
            if (s.contains(" ")) {
                return false;
            }
        }
        return true;
    }
}
