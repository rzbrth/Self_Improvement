package testcode;

class Parent {
    void msg()throws Exception{
        System.out.println("parent method");
    }
}

class TestExceptionChild5 extends Parent{
    void msg() {
        System.out.println("child method");
    }

    public static void main(String args[]){
        Parent p = new TestExceptionChild5();

        try {
            p.msg();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}