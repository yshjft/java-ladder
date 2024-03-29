package laddergame.domain.ladder;

import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.*;
import java.util.stream.IntStream;

import static laddergame.domain.ladder.Link.LINKED;
import static laddergame.domain.ladder.Link.UNLINKED;

public class Line {
    private static final int START_RANGE = 0;

    private final List<Link> links;

    private Line(LinkStrategy linkStrategy, int numberOfPlayers) {
        Deque<Link> links = new LinkedList<>();

        IntStream.range(START_RANGE, numberOfPlayers - 1)
                .forEach(i -> {
                    boolean linkable = linkStrategy.linkable();
                    Link before = Optional.ofNullable(links.peekLast())
                            .orElse(UNLINKED);
                    Link now = linkable && before.isUnLinked() ? LINKED : UNLINKED;
                    links.add(now);
                });

        this.links = new ArrayList<>(links);
    }

    public static Line newLine(LinkStrategy linkStrategy, int numberOfPlayers) {
        return new Line(linkStrategy, numberOfPlayers);
    }

    public List<Link> links() {
        return links;
    }
}
