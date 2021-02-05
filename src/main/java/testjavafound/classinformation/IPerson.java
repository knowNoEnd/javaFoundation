package main.java.testjavafound.classinformation;

public interface IPerson {
    //void use(CalculatorImpl calculator)
    //void use(ComputerImpl computer)
    //使用接口作为形参可以节约代码
    //可以使用多态动态绑定思维：
    //ICalculate calculate = new CalculatorImpl
    //ICalculate calculate = new ComputerImpl
    void use(ICalculate calculate);
}
