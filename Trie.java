import java.util.*;

public class Trie{
  private Map<Character, Trie> children;
  private boolean isLeaf;
  public Trie(){
    isLeaf = false;
    children = new HashMap<Character, Trie>();
  }

  public void insert(String key){
    Trie track = this;
    for(char c: key.toCharArray()){
      track.children.putIfAbsent(c, new Trie());
      track = track.children.get(c);
    }
    track.isLeaf = true;
  }

  public boolean search(String key){
    Trie track = this;
    for(char c: key.toCharArray()){
      track = track.children.get(c);
      if(track == null){
        return false;
      }
    }
    return track.isLeaf;
  }

}