package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int RANDOM_NUMBER_SIZE = 3;
    public List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < RANDOM_NUMBER_SIZE) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }
}
