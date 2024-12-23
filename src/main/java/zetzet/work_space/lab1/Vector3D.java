package zetzet.work_space.lab1;

public class Vector3D {
    private final double x1, y1, z1; // Координаты начальной точки
    private final double x2, y2, z2; // Координаты конечной точки

    // Конструктор
    public Vector3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }

    // Векторные координаты
    public double[] getVector() {
        return new double[]{x2 - x1, y2 - y1, z2 - z1};
    }

    // Длина вектора
    public double length() {
        double[] v = getVector();
        return Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
    }

    // Сложение векторов
    public Vector3D add(Vector3D other) {
        double[] v1 = this.getVector();
        double[] v2 = other.getVector();
        return new Vector3D(0, 0, 0, v1[0] + v2[0], v1[1] + v2[1], v1[2] + v2[2]);
    }

    // Вычитание векторов
    public Vector3D subtract(Vector3D other) {
        double[] v1 = this.getVector();
        double[] v2 = other.getVector();
        return new Vector3D(0, 0, 0, v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]);
    }

    // Скалярное произведение
    public double dotProduct(Vector3D other) {
        double[] v1 = this.getVector();
        double[] v2 = other.getVector();
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }

    // Косинус угла между векторами
    public double cosine(Vector3D other) {
        double dot = this.dotProduct(other);
        double len1 = this.length();
        double len2 = other.length();
        return dot / (len1 * len2);
    }

    @Override
    public String toString() {
        double[] v = getVector();
        return String.format("Vector(%.2f, %.2f, %.2f)", v[0], v[1], v[2]);
    }
}
