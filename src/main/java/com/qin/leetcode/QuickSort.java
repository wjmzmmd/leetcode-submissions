package com.qin.leetcode;

/**
 * vanilla quick-sort with no surprises
 *
 * @author qin Created at 2017-02-01 11:33
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    public QuickSort(T[] A) {
        super(A);
    }

    void recursiveQuickSort(int start, int end) {
        if (start >= end)
            return;
        T pivot = A[start]; // use A[start] as pivot
        int left = start + 1, right = end;
        while (left < right) {
            while (A[left].compareTo(pivot) <= 0 && left < right) {
                left++;
            }
            while (A[right].compareTo(pivot) >= 0 && left < right) {
                right--;
            }
            T tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
        }
        if (A[left].compareTo(pivot) >= 0) {
            left--; // if mid element lager than pivot, step back one ele
        }
        T tmp = A[left];
        A[left] = pivot;
        A[start] = tmp;
        recursiveQuickSort(start, left - 1);
        recursiveQuickSort(left + 1, end);
    }

    @Override
    protected void doSort() {
        recursiveQuickSort(0, A.length - 1);
    }

    public static void main(String[] args) {
        Integer[] A = new Integer[] { 2, 1, 3, 4, 7, 5, 6, 8 };
        new QuickSort<Integer>(A).sort();
    }
}
