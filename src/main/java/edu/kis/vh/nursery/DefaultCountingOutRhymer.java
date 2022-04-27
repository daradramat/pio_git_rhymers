package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int NUMBERS_ARR_INIT_SIZE = 12;
    public static final int ERR_CODE = -1;
    public static final int MAX_STACK_CAPACITY = 11;
    private final int[] numbers = new int[NUMBERS_ARR_INIT_SIZE];

    public int getTotal() {
        return total;
    }

    private int total = ERR_CODE;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == ERR_CODE;
    }

    public boolean isFull() {
        return total == MAX_STACK_CAPACITY;
    }

    protected int peekaboo() {
        if (callCheck())
            return ERR_CODE;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return ERR_CODE;
        return numbers[total--];
    }

}
