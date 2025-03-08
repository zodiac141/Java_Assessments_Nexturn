abstract class Trainer{
    abstract void train();
    //abstract dont have implementations details(methods)
}

class student extends Trainer{
    //child class only having the implementations()i.e abstract methods
    void train(){
        System.out.println("student training");
    }
}
public class test {
    public static void main(String[] args) {
        student obj = new student();
        obj.train();
    }


}
