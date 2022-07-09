package testcode;

class Threadlock {
    private final static String s1 = "java";
    private final static String s2 = "deadlock";
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                synchronized(s1) {
                	System.out.println("T1 locked--->S1");
                    try {
                        Thread.sleep(100);//Line 1
                    } catch (Exception e) {}
                    synchronized(s2) {
                    	System.out.println("T1 locked--->S2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized(s2) {
                	System.out.println("T2 locked--->S2");
                    try {
                        Thread.sleep(100);//Line 2
                    } catch (Exception e) {}
                    synchronized(s1) {
                    	System.out.println("T2 locked--->S1");
                    }
                }
            }
        };
        

        t2.start();
        t1.start();
    }
}