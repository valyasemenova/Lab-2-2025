import functions.FunctionPoint;
import functions.TabulatedFunction;

public class Main {
    public static void main(String[] args) {
    TabulatedFunction parabola = new TabulatedFunction(0.0, 10.0, 11);
    for (int i = 0; i < parabola.getPointsCount(); i++) {
            double x = parabola.getPointX(i);
            double y = x * x; 
            parabola.setPointY(i, y);
        }
        System.out.println("Табулированная функция y = x^2:");
        System.out.println("Область определения: от " + parabola.getLeftDomainBorder() + 
                         " до " + parabola.getRightDomainBorder());
        System.out.println("Количество точек: " + parabola.getPointsCount());
        
        System.out.println("Точки функции:");
        for (int j = 0; j < parabola.getPointsCount(); j++) {
            System.out.println("  (" + parabola.getPointX(j) + "; " + parabola.getPointY(j) + ")");
        }
        
        // Вычисляем значение функции в некоторых точках
        System.out.println("\nЗначения функции:");
        System.out.println("f(1.0) = " + parabola.getFunctionValue(1.0));
        System.out.println("f(2.5) = " + parabola.getFunctionValue(2.5));
        System.out.println("f(6.4) = " + parabola.getFunctionValue(6.4));
        System.out.println("f(11.0) = " + parabola.getFunctionValue(11.0)); 
    
}
}
