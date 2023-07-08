package best.interview.questions.easy;

import java.util.*;

public class HappyNumber {

    public static void main(String[] args) throws CloneNotSupportedException {
        Object o = new Object();
        MyStruct struct = new MyStruct(1, "aboba", o);

        MyStruct clone = struct.clone();

        System.out.println(struct.object == clone.object);
    }

    private static class MyStruct implements Cloneable {
        private int value;
        private String str;
        private Object object;

        public MyStruct(int value, String str, Object object) {
            this.value = value;
            this.str = str;
            this.object = object;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyStruct myStruct = (MyStruct) o;
            return value == myStruct.value && Objects.equals(str, myStruct.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, str);
        }

        @Override
        public MyStruct clone() {
            try {
                return (MyStruct) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            return "MyStruct{" +
                    "value=" + value +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    public boolean isHappy(int number) {
        if (number == 0) {
            return false;
        }
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return false;
    }
}
