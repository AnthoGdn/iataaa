package io.github.anthogdn.iataaa.checkersDomain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Move {
    private List<Case[]> move;

    public Move() {
        this.move = new ArrayList<>();
    }
    public Move(List<Case[]> move) {
        this.move = new ArrayList<>(move);
    }

    public Move(Case[] cases) {
        this.move = new ArrayList<>();
        this.move.add(cases);
    }

    public void add(Case[] cases) {
        move.add(cases);
    }
    public void addAll(List<Case[]> move) {
        this.move.addAll(move);
    }
    public void addAll(Move move) {
        this.move.addAll(move.getMove());
    }
    public Case[] get(int i) {
        return move.get(i);
    }

    public Case[] getLast() {
        return move.get(move.size() - 1);
    }

    public Move clone() {
        return new Move(new ArrayList<>(move));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;
        Move move1 = (Move) o;
        for (int i = 0; i < move.size(); ++i) {
            if (!Arrays.equals(move.get(i), move1.get(i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(move);
    }

    public List<Case[]> getMove() {
        return move;
    }
    public void setMove(List<Case[]> move) {
        this.move = move;
    }

    @Override
    public String toString() {
        List<String> casesStringList = move
                .stream()
                .map(cases -> new CheckersBoard(cases).toString())
                .collect(Collectors.toList());
        return "Move{" +
                "size = " + move.size() + "\n" +
                "move=\n" + String.join("\n", casesStringList) +
                '}';
    }
}
