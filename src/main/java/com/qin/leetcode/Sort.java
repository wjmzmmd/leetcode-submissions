package com.qin.leetcode;

/**
 * @author qin Created at 2017-02-01 12:49
 */
public abstract class Sort<T extends Comparable<T>> {
    final T[] A;

    Sort(T[] A) {
        this.A = A;
    }

    final public void sort() {
        doSort();
        print();
    }

    protected abstract void doSort();

    private void print() {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            System.out.print(A[i]);
            if (i != length - 1) {
                System.out.print(",");
            }
        }
    }
}
