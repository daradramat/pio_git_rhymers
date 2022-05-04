package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;
import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testDefaultRhymersFactory() {
        RhymersFactory rhymersFactory = new DefaultRhymersFactory();

        Assert.assertNotNull(rhymersFactory.getStandardRhymer());
        Assert.assertNotNull(rhymersFactory.getFalseRhymer());
        Assert.assertNotNull(rhymersFactory.getFIFORhymer());
        Assert.assertNotNull(rhymersFactory.getHanoiRhymer());
    }

    @Test
    public void testIntLinkedList() {
        IntLinkedList intLinkedList = new IntLinkedList();
        int testValue1 = 1;
        int testValue2 = 2;

        Assert.assertTrue(intLinkedList.isEmpty());

        intLinkedList.push(testValue1);
        Assert.assertEquals(intLinkedList.top(), testValue1);
        intLinkedList.push(testValue2);
        Assert.assertEquals(intLinkedList.top(), testValue2);

        Assert.assertFalse(intLinkedList.isEmpty());

        Assert.assertEquals(intLinkedList.pop(), testValue2);
        Assert.assertEquals(intLinkedList.pop(), testValue1);

        Assert.assertTrue(intLinkedList.isEmpty());
    }

    @Test
    public void testFIFORhymer() {
        FIFORhymer fifoRhymer = new FIFORhymer();

        int testValue1 = 1;
        int testValue2 = 2;
        int testValue3 = 3;

        fifoRhymer.countIn(testValue1);
        fifoRhymer.countIn(testValue2);
        fifoRhymer.countIn(testValue3);

        Assert.assertEquals(fifoRhymer.countOut(), testValue1);
        Assert.assertEquals(fifoRhymer.countOut(), testValue2);
        Assert.assertEquals(fifoRhymer.countOut(), testValue3);

        Assert.assertTrue(fifoRhymer.callCheck());
    }

    @Test
    public void testHanoiRhymer() {
        HanoiRhymer hanoiRhymer = new HanoiRhymer();
        int testValue = 1;
        
        hanoiRhymer.countIn(testValue);
        Assert.assertEquals(testValue, hanoiRhymer.peekaboo());
    }
}

//14. wszystkie testy wykonują się poprawnie