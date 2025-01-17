package org.colonelkai.publictransit.line;

import org.colonelkai.publictransit.node.Node;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public enum LineDirection {

    POSITIVE(true),
    NEGATIVE(false);

    private final boolean isPositive;

    LineDirection(boolean isPositive) {
        this.isPositive = isPositive;
    }

    public boolean isPositive() {
        return this.isPositive;
    }

    public LineDirection getOpposite() {
        return valueOf(!this.isPositive);
    }

    public Optional<Node> getNextNode(int currentIndex, List<Node> nodes) {
        if (nodes.isEmpty()) {
            return Optional.empty();
        }
        return this.next(currentIndex, nodes);
    }

    private Optional<Node> next(int currentIndex, List<Node> nodes) {
        int index = currentIndex + (this.isPositive ? 1 : -1);

        if (index < nodes.size()) {
            //valid index
            return Optional.of(nodes.get(index));
        }
        return Optional.empty();
    }

    public boolean isAtEndOfLine(int currentIndex, List<Node> nodes) {
        return this.next(currentIndex, nodes).isEmpty();
    }

    public static LineDirection valueOf(boolean isPositive) {
        return isPositive ? POSITIVE : NEGATIVE;
    }
}
