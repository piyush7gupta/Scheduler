package Trie;


import Util.NodeInterface;


public class TrieNode<T> implements NodeInterface<T> {

    public TrieNode[] arr;
    public T stud;
    public TrieNode parent;
    public int level;
    public int size;
    public int val;
    public TrieNode()
    {
        level=0;
        size=0;
        arr = (new TrieNode[97]);
        val=-1;
    }
    @Override
    public T getValue() {
        return stud;
    }


}