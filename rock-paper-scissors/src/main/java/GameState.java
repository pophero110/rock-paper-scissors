

import java.util.ArrayList;

public class GameState {
    private String gameMode;
    private int playerTurn = 1;
    private int gameState = -1;
    private boolean isPlayer1Win;
    private boolean isPlayer2Win;

    private final Player player1;
    private Player player2;
    private String player1SelectedShape;
    private String player2SelectedShape;
    private final ArrayList<String> history = new ArrayList<>();

    public GameState(Player player1, ComputerPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void updatePlayerState() {
        player1.setWinning(isPlayer1Win);
        player2.setWinning(isPlayer2Win);
        player1.setSelectedShape(player1SelectedShape);
        player2.setSelectedShape(player2SelectedShape);
        if (isPlayer1Win) {
            player1.setWinningPoints(player1.getWinningPoints() + 1);
            player2.setLosingPoints(player2.getLosingPoints() + 1);
        } else if (isPlayer2Win) {
            player2.setWinningPoints(player2.getWinningPoints() + 1);
            player1.setLosingPoints(player1.getLosingPoints() + 1);
        } else {
            player1.setTiePoints(player1.getTiePoints() + 1);
            player2.setTiePoints(player2.getTiePoints() + 1);
        }
    }

    public void reset() {
        isPlayer1Win = false;
        isPlayer2Win = false;
        gameState = -1;
        playerTurn = 1;
    }

    public void addHistory() {
        String selectedShapeByTwoPlayers = String.format("%s picked %s, %s picked %s",
                player1.getName(),
                player1.getSelectedShape(),
                player2.getName(),
                player2.getSelectedShape());
        history.add((player1.isWinning() ? player1.getName() : player2. getName()) + " WIN: " + selectedShapeByTwoPlayers);
    }
    public ArrayList getHistory() {
        return history;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public boolean isPlayer1Win() {
        return isPlayer1Win;
    }

    public void setPlayer1Win(boolean player1Win) {
        isPlayer1Win = player1Win;
    }

    public boolean isPlayer2Win() {
        return isPlayer2Win;
    }

    public void setPlayer2Win(boolean player2Win) {
        isPlayer2Win = player2Win;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getPlayer1SelectedShape() {
        return player1SelectedShape;
    }

    public void setPlayer1SelectedShape(String player1SelectedShape) {
        this.player1SelectedShape = player1SelectedShape;
    }

    public String getPlayer2SelectedShape() {
        return player2SelectedShape;
    }

    public void setPlayer2SelectedShape(String player2SelectedShape) {
        this.player2SelectedShape = player2SelectedShape;
    }
}
