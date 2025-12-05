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
        
        System.out.println("\n getPoint()");
        System.out.println("\n Получение точки с индексом 5:");
        FunctionPoint point5 = parabola.getPoint(5);
        System.out.println("   Точка[5] = (" + point5.get_x() + "; " + point5.get_y() + ")");
        
        System.out.println("\n Замена точки с индексом 5:");
        FunctionPoint newPoint = new FunctionPoint(5.0, 30.0);
        parabola.setPoint(5, newPoint);
        System.out.println("   После замены: (" + parabola.getPointX(5) + "; " + parabola.getPointY(5) + ")");

        System.out.println("\n setPointX() и setPointY()");
        System.out.println("\n Изменение X точки с индексом 3:");
        System.out.println("   До: (" + parabola.getPointX(3) + "; " + parabola.getPointY(3) + ")");
        parabola.setPointX(3, 3.5);
        System.out.println("   После: (" + parabola.getPointX(3) + "; " + parabola.getPointY(3) + ")");
        
        System.out.println("\n Изменение Y точки с индексом 3:");
        parabola.setPointY(3, 20.0);
        System.out.println("   После изменения Y: (" + parabola.getPointX(3) + "; " + parabola.getPointY(3) + ")");
        
          System.out.println("\n addPoint()");
        System.out.println("Точки до добавления (первые 5):");
        for (int i = 0; i < Math.min(5, parabola.getPointsCount()); i++) {
            System.out.println("   [" + i + "] = (" + parabola.getPointX(i) + "; " + parabola.getPointY(i) + ")");
        }
        
        System.out.println("\n Добавление новой точки (2.5, 10.0):");
        parabola.addPoint(new FunctionPoint(2.5, 10.0));
        System.out.println("   Количество точек после добавления: " + parabola.getPointsCount());
        
        System.out.println("\n Поиск добавленной точки:");
        for (int i = 0; i < parabola.getPointsCount(); i++) {
            if (Math.abs(parabola.getPointX(i) - 2.5) < 1e-10) {
                System.out.println("   Найдена в позиции " + i + ": (" + 
                                 parabola.getPointX(i) + "; " + parabola.getPointY(i) + ")");
                break;
            }
        }
        
        System.out.println("\n deletePoint()");
        System.out.println("Удаление точки с индексом 2:");
        System.out.println("   Точка[2] до удаления: (" + parabola.getPointX(2) + "; " + parabola.getPointY(2) + ")");
        parabola.deletePoint(2);
        System.out.println("   Количество точек после удаления: " + parabola.getPointsCount());
        System.out.println("   Точка[2] после удаления: (" + parabola.getPointX(2) + "; " + parabola.getPointY(2) + ")");


        System.out.println("\n Проверка порядка точек после всех операций");
        System.out.println("X координаты в порядке возрастания:");
        for (int i = 0; i < parabola.getPointsCount(); i++) {
            System.out.println("   [" + i + "] X = " + parabola.getPointX(i));
        }
        // Вычисляем значение функции в некоторых точках
        System.out.println("\nЗначения функции:");
        System.out.println("f(1.0) = " + parabola.getFunctionValue(1.0));
        System.out.println("f(2.5) = " + parabola.getFunctionValue(2.5));
        System.out.println("f(6.4) = " + parabola.getFunctionValue(6.4));
        System.out.println("f(11.0) = " + parabola.getFunctionValue(11.0)); 
    
}
}
