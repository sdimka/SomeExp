package streamApiExpl;

public class MegaClass {
    public newClass nc = new newClass(12);

    public void varScope(){

        final int[] num = new int[5];

        new Runnable() {
            @Override
            public void run() {
                num[0] = 2;
            }
        };

    }

    static class newClass {
        int i;

        public newClass(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }
    }
}
