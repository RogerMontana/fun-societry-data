package com.funsocietry.snippy.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoardGameAlgorithm {

    static class BoardTile {

        int number;
        long isReward;

        public BoardTile(int number, long isReward) {
            this.number = number;
            this.isReward = isReward;
        }

        @Override
        public String toString() {
            return "BoardTile{" +
                   "number=" + number +
                   ", isReward=" + isReward +
                   '}';
        }
    }

    static class Wheel {

        public Wheel(int wheelValue, long isReward) {
            this.wheelValue = wheelValue;
            this.isReward = isReward;
        }

        int wheelValue;
        long isReward;

        @Override
        public String toString() {
            return "Wheel{" +
                   "wheelValue=" + wheelValue +
                   ", isReward=" + isReward +
                   '}';
        }
    }

    static class Game {

        public List<BoardTile> boardTiles;
        public LinkedList<Wheel> userWheelsToFinishBoard;
        public Wheel nextUserWheelByConfig;
        public int userPosition;
        public int tilesNumber;



        public Game(List<BoardTile> boardTiles, int wheelsToFinish) {
            this.boardTiles = boardTiles;
            this.userWheelsToFinishBoard = generateWheels(wheelsToFinish);
            this.nextUserWheelByConfig = userWheelsToFinishBoard.getFirst();
            this.userPosition = 0;
            this.tilesNumber = boardTiles.size();
        }

        public void dragonHitAndGetNewUserPosition(int dragonStepBack) {
            //int nextUserWheelId = userWheelsToFinishBoard.indexOf(nextUserWheelByConfig);

            nextUserWheelByConfig = userWheelsToFinishBoard.getFirst();
            if (this.userPosition < dragonStepBack) {
                this.userPosition = 0;
            } else {
                this.userPosition = userPosition - dragonStepBack;
            }
            System.out.println("User Position After HIT:" + userPosition);
            //Todo calculate wheel Value regarding wheel no rewards
            //userWheelsToFinishBoard.add(nextUserWheelId, new Wheel(3,0));
            generateWheels(this.userWheelsToFinishBoard.size() + 1);
            int allWheelsSteps = userWheelsToFinishBoard.stream().map(w -> w.wheelValue).reduce((a, b) -> a + b).get();
            if (allWheelsSteps < boardTiles.size() && allWheelsSteps >= boardTiles.size() + 8) {
                generateWheels(boardTiles.size());
            }
        }

        private void getFirstAvalibleNoReward() {

        }

        public LinkedList<Wheel> generateWheels(int wheels) {
            LinkedList<Wheel> wheelLinkedList = new LinkedList<>();
            for (int i = 0; i <= wheels; i++) {
                //TODO Make it by normal
                int randomNum = ThreadLocalRandom.current().nextInt(1, 8);
                BoardTile boardTile = boardTiles.get(randomNum);
                wheelLinkedList.add(new Wheel(randomNum, boardTile.isReward));
            }
            System.out.println(wheelLinkedList);
            return userWheelsToFinishBoard = wheelLinkedList;
        }

        public void spinWheel() {

            Wheel first = userWheelsToFinishBoard.getFirst();
            int steps = first.wheelValue;
            System.out.println("Spin wheel with " + first + " proceed steps: " + steps);
            userWheelsToFinishBoard.removeFirst();
            nextUserWheelByConfig = userWheelsToFinishBoard.getFirst();
            userPosition = userPosition + steps;
            System.out.println("User Position After SPIN:" + userPosition);

        }

        @Override
        public String toString() {
            return "Game{" +
                   //"boardTiles=" + boardTiles +
                   ", userWheelsToFinishBoard=" + userWheelsToFinishBoard +
                   ", nextUserWheelByConfig=" + nextUserWheelByConfig +
                   ", userPosition=" + userPosition +
                   ", tilesNumber=" + tilesNumber +
                   '}';
        }
    }


    public static void main(String[] args) {

        List<BoardTile> tiles = IntStream.range(0, 39).mapToObj(i -> new BoardTile(i, Math.round(Math.random()))).collect(Collectors.toList());
        Game game = new Game(tiles, 8);
        System.out.println(game.toString());
        game.spinWheel();
        System.out.println(game.toString());
        game.dragonHitAndGetNewUserPosition(5);
        System.out.println(game.toString());
        game.spinWheel();
        System.out.println(game.toString());
        while (game.userWheelsToFinishBoard.size() != 0){
            game.spinWheel();
            System.out.println(game.toString());
        }
    }
}
