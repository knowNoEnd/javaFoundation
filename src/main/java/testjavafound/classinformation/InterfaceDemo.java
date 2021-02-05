package main.java.testjavafound.classinformation;

//接上述的例子：动态思维Demo2
public class InterfaceDemo {

    public static void main(String[] args) {
        // 利用多态创建
        //Student student = new Student();
        //假如使用的是Student实现类，想换新的对象时就需要创建新的对象
        //与上述Demo一样，假如有多个Iperson实现类
        //利用多态的动态绑定思维，就可以随时改变对象
        IPerson p = new Student();
        //p = new Teacher()

        // 利用多态创建
        ICalculate calculate = new CalculatorImpl();
        p.use(calculate);

        ICalculate calculate1 = new ComputerImpl();
        p.use(calculate1);

    }

}

class Student implements IPerson {
    public void use(ICalculate calculate){
        System.out.println("我是Iperson的导出类");;
    }
}
