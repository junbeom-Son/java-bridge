package bridge;

import java.util.List;

public class Application {

    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        outputView.printStartMessage();
        int bridgeSize = getBridgeSizeInput();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        move(bridgeSize);
    }

    private static int getBridgeSizeInput() {
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return bridgeSize;
    }

    private static void move(int bridgeSize) {
        for (int i = 0; i < bridgeSize; ++i) {
            String moveDirection = getMoveDirectionInput();
        }
    }

    private static String getMoveDirectionInput() {
        String moveDirection;
        while (true) {
            try {
                moveDirection = inputView.readMoving();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
        return moveDirection;
    }
}
