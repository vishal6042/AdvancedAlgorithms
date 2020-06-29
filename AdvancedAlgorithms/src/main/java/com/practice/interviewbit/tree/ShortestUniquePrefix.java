package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

class Trie {
    Trie child[];
    boolean isLeaf;
    int count;

    public Trie() {
        child = new Trie[256];
        isLeaf = false;
        count = 0;
    }
}

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> words) {
        ArrayList<String> ans = new ArrayList<>();
        if (words == null || words.size() == 0) {
            return ans;
        }

        Trie root = new Trie();
        for (String word : words) {
            insertToTrie(word, root);
        }
        for (String word : words) {
            int index = getIndex(word, root);
            if (index != -1) {
                ans.add(word.substring(0, index + 1));
            }
        }

        return ans;
    }

    private int getIndex(String word, Trie root) {
        Trie crawl = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (crawl.child[c] == null) {
                return -1;
            }
            crawl = crawl.child[c];
            if (crawl.count == 1) {
                return i;
            }
        }
        if (crawl.isLeaf) {
            return word.length();
        }
        return -1;
    }

    private void insertToTrie(String word, Trie root) {
        Trie crawl = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (crawl.child[c] == null) {
                crawl.child[c] = new Trie();
            }
            crawl = crawl.child[c];
            crawl.count++;
        }
        crawl.isLeaf = true;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUniquePrefix().prefix(new ArrayList<>(Arrays.asList(
                "zebra", "dog", "duck", "dove"
        ))));
    }

}
