package functions;

public class TabulatedFunction {
    private FunctionPoint[] points;
    private int points_count;

    public TabulatedFunction(double leftX, double rightX, int pointsCount){
        this.points_count = pointsCount;
        this.points = new FunctionPoint[pointsCount];

        double step = (rightX - leftX) / (pointsCount - 1);
        
        for (int i = 0; i < points_count; i++) {
            double x = leftX + i * step;
            points[i] = new FunctionPoint(x, 0.0);
        }
    }

    TabulatedFunction(double leftX, double rightX, double[] values){
        this.points_count = values.length;
        this.points = new FunctionPoint[points_count]; 

        double step = (rightX - leftX) / (points_count - 1);
        
        for (int i = 0; i < points_count; i++) {
            double x = leftX + i * step;
            points[i] = new FunctionPoint(x, values[i]);
        }
    }

    public double getLeftDomainBorder(){
        return points[0].get_x();
    }

    public double getRightDomainBorder(){
        return points[points_count - 1].get_x();
    }

    public double getFunctionValue(double x){

        if (x < getLeftDomainBorder() || x > getRightDomainBorder()) {
            return Double.NaN;
        }

         for (int i = 0; i < points_count; i++) {

            if (Math.abs(x - points[i].get_x()) < 1e-10) {
                return points[i].get_y();
            }
        
        if (i < points_count - 1) {
            double x1 = points[i].get_x();
            double x2 = points[i + 1].get_x();
            
            if (x > x1 && x < x2) {
                double y1 = points[i].get_y();
                double y2 = points[i + 1].get_y();
                return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
            }
        }
    }
    return Double.NaN;
    }

    public int getPointsCount() {
            return points_count;
        }

    public FunctionPoint getPoint(int index){
        return new FunctionPoint(points[index]); 
    }

    public void setPoint(int index, FunctionPoint point){
        if (index < 0) {
            throw new IndexOutOfBoundsException("Индекс меньше нуля");
        }

        if (index >= points_count) {
            throw new IndexOutOfBoundsException("Индекс больше размера");
        }

        if (point == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
        if (index > 0) {
            double leftX = points[index - 1].get_x();
            if (point.get_x() <= leftX) {
                throw new IllegalArgumentException("X должен быть больше чем у левой точки");
            }
        }
        if (index < points_count - 1) {
            double rightX = points[index + 1].get_x();
            if (point.get_x() >= rightX) {
                throw new IllegalArgumentException("X должен быть меньше чем у правой точки");
            }
        }
        points[index] = new FunctionPoint(point);
    }

    public double getPointX(int index){
        if (index < 0 || index >= points_count) {
         throw new IndexOutOfBoundsException("Выход за границы");
    }
        return points[index].get_x();
    }

    public void setPointX(int index, double x){
        if (index < 0 || index >= points_count) {
            throw new IndexOutOfBoundsException("Выход за границы");
        }
        if (index > 0 && x <= points[index - 1].get_x()) {
            throw new IllegalArgumentException("X должен быть больше чем у левой точки");
        }
        if (index < points_count - 1 && x >= points[index + 1].get_x()) {
            throw new IllegalArgumentException("X должен быть меньше чем у правой точки");
        }
        points[index].set_x(x);
    }

    public double getPointY(int index){
        if (index < 0 || index >= points_count) {
         throw new IndexOutOfBoundsException("Выход за границы");
    }
        return points[index].get_y();
    }

     public void setPointY(int index, double y){
        if (index < 0 || index >= points_count) {
            throw new IndexOutOfBoundsException("Выход за границы");
        }
        points[index].set_y(y);
     }

     public void deletePoint(int index){
         if (index < 0 || index >= points_count) {
            throw new IndexOutOfBoundsException("Выход за границы");
        }
        for (int i = index; i < points_count - 1; i++) {
            points[i] = points[i + 1];
        }

        points[points_count - 1] = null;
        points_count--;
     }

     public void addPoint(FunctionPoint point){
        if (point == null) {
            throw new IllegalArgumentException("Точка не может быть null");
        }
    
        for (int i = 0; i < points_count; i++) {
            if (Math.abs(point.get_x() - points[i].get_x()) < 1e-10) {
                throw new IllegalArgumentException("Точка с таким x уже существует");
            }
        }

        int insertIndex = points_count; 

        for (int i = 0; i < points_count; i++) {
            if (point.get_x() < points[i].get_x()) {
                insertIndex = i;
                break;
            }
        }

        if (points_count >= points.length) {
            FunctionPoint[] newPoints = new FunctionPoint[points.length *2];
            // Копируем старые точки в новый массив
            System.arraycopy(points, 0, newPoints, 0, points_count);
            points = newPoints;
        }

        if (insertIndex < points_count) {
            System.arraycopy(points, insertIndex, points, insertIndex + 1, points_count - insertIndex);
        }
        
        points[insertIndex] = new FunctionPoint(point);
        points_count++;
     }
}

