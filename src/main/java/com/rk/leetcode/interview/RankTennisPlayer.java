package com.rk.leetcode.interview;

import com.rk.leetcode.model.Player;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankTennisPlayer {

  public static void main(String[] args) {

    List<Player> players = new ArrayList<>();
    populatePlayerList(players);

  }


  private static void populatePlayerList(List<Player> players){
    players.add(new Player(10,10,2));
    players.add(new Player(11,10,3));
    players.add(new Player(12,10,4));
    players.add(new Player(13,10,5));
    players.add(new Player(14,10,6));

  }


}
