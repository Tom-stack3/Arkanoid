package arkanoid.game;

/**
 * @author Tommy Zaft
 * <p>
 * A counter.
 */
public class Counter {
    private int count;

    /**
     * constructor for a counter.
     *
     * @param count the count to start counting from.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * constructor for a counter.
     */
    public Counter() {
        this(0);
    }

    /**
     * add number to current count.
     *
     * @param number number
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number number
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     *
     * @return get current count.
     */
    public int getValue() {
        return this.count;
    }
}
