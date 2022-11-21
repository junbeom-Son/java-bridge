package bridge;

import bridge.messages.InputMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String upperSideCharacter = "U";
    private final String lowerSideCharacter = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int lastMovePosition, String movedDirection, List<String> bridge) {
        printUpperSideMap(lastMovePosition, movedDirection, bridge);
        printLowerSideMap(lastMovePosition, movedDirection, bridge);
    }

    private void printUpperSideMap(int lastMovePosition, String movedDirection, List<String> bridge) {
        System.out.print("[");
        for (int i = 0; i < lastMovePosition; ++i) {
            System.out.print(" " + getOneBlockFormat(upperSideCharacter, bridge.get(i)) + " |");
        }
        System.out.print(getLastBlockFormat(upperSideCharacter, movedDirection, bridge.get(lastMovePosition)));
        System.out.println("]");
    }

    private void printLowerSideMap(int lastMovePosition, String movedDirection, List<String> bridge) {
        System.out.print("[");
        for (int i = 0; i < lastMovePosition; ++i) {
            System.out.print(" " + getOneBlockFormat(lowerSideCharacter, bridge.get(i)) + " |");
        }
        System.out.print(getLastBlockFormat(lowerSideCharacter, movedDirection, bridge.get(lastMovePosition)));
        System.out.println("]");
    }

    private String getOneBlockFormat(String side, String direction) {
        if (side.equals(direction)) {
            return "O";
        }
        return " ";
    }

    private String getLastBlockFormat(String side, String movedDirection, String answerDirection) {
        if (!side.equals(movedDirection)) {
            return "   ";
        }
        if (movedDirection.equals(answerDirection)) {
            return " O ";
        }
        return " X ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartMessage() {
        System.out.println(InputMessage.START_MESSAGE.getMessage());
    }

    public void printBridgeSizeInputMessage() {
        System.out.println();
        System.out.println(InputMessage.BRIDGE_SIZE_INPUT_MESSAGE.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printChooseMovingInputMessage() {
        System.out.println();
        System.out.println(InputMessage.MOVE_DIRECTION_INPUT_MESSAGE.getMessage());
    }

    public void printRetryInputMessage() {
        System.out.println();
        System.out.println(InputMessage.RETRY_INPUT_MESSAGE.getMessage());
    }
}
