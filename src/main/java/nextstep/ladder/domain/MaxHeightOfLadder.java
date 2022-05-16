package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.NotAllowNegativeOrZero;
import nextstep.ladder.domain.exceptions.NotNumberStringIsNotAllowException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxHeightOfLadder {
    private static final int MIN = 1;

    private final int maxHeightOfLadder;

    public MaxHeightOfLadder(String string) {
        this(toInt(string));
    }

    MaxHeightOfLadder(int maxHeightOfLadder) {
        checkLessThenMin(maxHeightOfLadder);
        this.maxHeightOfLadder = maxHeightOfLadder;
    }

    private static int toInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NotNumberStringIsNotAllowException();
        }
    }

    private void checkLessThenMin(int maxHeightOfLadder) {
        if (maxHeightOfLadder < MIN) {
            throw new NotAllowNegativeOrZero();
        }
    }

    public Lines getLines(Members members) {
        List<Line> lines = IntStream.range(0, this.maxHeightOfLadder)
                .mapToObj(i -> new Line(members))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    @Override
    public String toString() {
        return String.valueOf(this.maxHeightOfLadder);
    }
}
