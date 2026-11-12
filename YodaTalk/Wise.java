import java.util.Scanner;

class Wise {
   public static void main(String[] args) {
	    // initializes the valid sentences
        String[] eligible = {"will", "must", "have", "are", "can"};

        // initializes found string
        String found = "";

        // initializes scanner object and asks for input
        Scanner input = new Scanner(System.in);
        System.out.println("Speak your wisdowm: ");

        // stores user input and closes input object
        String sentence = input.nextLine().toLowerCase();
        input.close();

        // loops through eligible array of sentences
        for (int i = 0; i < eligible.length; i++) {
            // checks if sentence contains any of the eliglibe sentences
            if (sentence.contains(eligible[i])) {
                found = eligible[i];
                break;
            } else if (i == eligible.length - 1 && !sentence.contains(eligible[i])) {
                System.out.println("No wise word found :(");
                return;
            }
        }

        // return a array of chars based on sentence
        char[] sentenceArr = sentence.toCharArray();

        // index of found word in sentence
        // i.e "we must not fear" returns the index of 3
        int indexOfFound = sentence.indexOf(found, 0);

        // last character of found word in sentence
        // return the addition of index of found (so, first char) with length of it minus 1, which resolves at end of the substring
        char endChr = sentence.charAt(indexOfFound + (found.length() - 1));

        // index of the last char of found word in sentence
        // starts from indexOfFound to prevent red flag of any other chars elsewhere in sentence.
        int lastChrIndex = sentence.indexOf(endChr, indexOfFound);

        // case occurence: will has two sequential "l" at its end, so it would wrongly flag first "l" as the end of the word instead of the second one. for now we increase index by one.
        if (found.equals("will")) {
            lastChrIndex = lastChrIndex + 1;
        }

        // stores the last half aka not-wise-word half of the sentence
        String restHalf = sentence.substring(lastChrIndex + 1).trim();

        // initializes stringbuilder for wise-word-half of the sentence
        StringBuilder foundHalf = new StringBuilder();

        // loops through sentenceArr until i == last char on found index and append each upon foundHalf.
        // i.e sentenceArr == they must suffer && found == must will loop from first char (t) until last char of found (t)
        for (int i = 0; i <= lastChrIndex ; i++) {
            char chr = sentenceArr[i];
            foundHalf.append(Character.toString(chr));
        }

         // finally prints the concatened halves, separated by coma and space
        System.out.println(restHalf.concat(", " + foundHalf.toString()));
    }
}
