package com.mj147;


import java.util.Arrays;

public class Sequence {

    int sequenceLength = 5;
    private int[] sequence = new int[sequenceLength];

    public int getLastElement() {
        return sequence[sequenceLength - 1];
    }

    public void makeSequence() {

        int leap = (int) (Math.random() * 10) + 2 ;
        sequence[0] = (int) (Math.random() * 50);

        int x = (int) (Math.random()*4);
        switch (x) {
            case 0:
                for (int i = 1; i < sequenceLength; i++) {
                    sequence[i] = sequence[i - 1] + leap;
                }
                break;

            case 1:
                for (int i = 1; i < sequenceLength; i++) {
                    sequence[i] = sequence[i - 1] - leap;
                }
                break;

            case 2:
                leap = (int) (Math.random() * 3) + 2 ;
                sequence[0] = (int) (Math.random() * 3 + 2);
                for (int i = 1; i < sequenceLength; i++) {
                    sequence[i] = sequence[i - 1] * leap;
                }
                break;

            case 3:
                leap = (int) (Math.random() * 3) + 2 ;
                sequence[0] = (int) (Math.random() * 3 + 2);
                sequence[4] = sequence[0]*leap;
                for (int i = 3; i >= 0; i--) {
                    sequence[i] = sequence[i + 1] * leap;
                }

                break;
        }

        System.out.println(Arrays.toString(sequence));
    }

    @Override
    public String toString() {

        String text = "";

        for (int i = 0; i < sequenceLength - 1; i++) {
            text += sequence[i] + "   ";
        }

        return text;
    }
}
