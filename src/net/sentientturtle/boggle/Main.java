package net.sentientturtle.boggle;

import net.sentientturtle.boggle.tree.WordTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WordTree wordTree = new WordTree();
        HashSet<String> wordSet = new HashSet<>();
        Scanner scanner = new Scanner(new File("rsc/wordlist.txt"));
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (word.length() > 3) {
                wordTree.addWord(word);
                wordSet.add(word);
            }
        }
        scanner.close();

        Boggle boggle = new Boggle(15);
        System.out.println(boggle.toString());
        List<String> words = boggle.findWords(wordTree);
        System.out.println(words);

        for (String word : words) assert wordSet.contains(word);
    }
}
