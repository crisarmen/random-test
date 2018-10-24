package com.test;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        boolean abc = t.search("abc");
        t.insert("abca");
        abc = t.search("abc");
        abc = t.startsWith("abc");
        abc = t.search("abca");
        t.insert("abc");
        abc = t.search("abca");
        abc = t.search("abc");
        int a  = 1;

    }
    private TNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word.getBytes(), 0);
    }

    private void insert(TNode r, byte[] bytes, int idx) {
        if(idx < bytes.length) {
            byte b = bytes[idx];
            if (r.children[b - 'a'] == null) {
                r.children[b - 'a'] = new TNode();
            }
            insert(r.children[b - 'a'], bytes, idx + 1);
            if(idx == bytes.length - 1) {
                r.children[b - 'a'].finalWorld = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TNode n = search(root, word.getBytes(), 0);
        if(n == null) {
            return false;
        } else {
            return n.finalWorld;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(root, prefix.getBytes(), 0) != null;
    }

    private TNode search(TNode r, byte[] bytes, int idx) {
        if(idx < bytes.length) {
            int b = bytes[idx] - 'a';
            if(r.children[b] == null) {
                return null;
            } else {
                return search(r.children[b], bytes, idx + 1);
            }
        } else {
            return r;
        }
    }

    static class TNode {
        TNode[] children = new TNode[26];
        boolean finalWorld = false;
    }
}
