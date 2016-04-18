package view;

/**
 * Referencias:
 * 
 * http://www.pontov.com.br/site/arquitetura/54-matematica-e-fisica/132-o-uso-de-vetores-nos-jogos
 * https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2d.htm
 * 
 * @author leonardo
 */
public class Vec4 {

    public static double[] create(double x, double y, double z, double w) {
        double v[] = new double[3];
        set(v, x, y, z, w);
        return v;
    }
    
    public static void set(double v[], double x, double y, double z, double w) {
        v[0] = x;
        v[1] = y;
        v[2] = z;
        v[3] = w;
    }

    // módulo ou intensidade
    public static double getSize(double v[]) {
        double x = v[0];
        double y = v[1];
        double z = v[2];
        return (double) Math.sqrt(x * x + y * y + z * z);
    }

    public static void add(double[] a, double[] b, double[] r) {
        r[0] = a[0] + b[0];
        r[1] = a[1] + b[1];
        r[2] = a[2] + b[2];
    }

    public static void sub(double[] a, double[] b, double[] r) {
        r[0] = a[0] - b[0];
        r[1] = a[1] - b[1];
        r[2] = a[2] - b[2];
    }

    // Vetor pode ser multiplicado por uma escalar
    public static void multiply(double scalar, double[] v) {
        v[0] = scalar * v[0];
        v[1] = scalar * v[1];
        v[2] = scalar * v[2];
    }

    // normalizar significa transformar o seu módulo (intensidade) para 1
    // util quando queremos que o vetor tenha um tamanho específico:
    // normaliza e depois multiplica pelo tamanho que gostaria que o vetor tivesse
    public static void normalize(double[] v) {
        double size = getSize(v);
        multiply(1 / size, v);
    }

    // http://en.wikipedia.org/wiki/Cross_product
    // http://tutorial.math.lamar.edu/Classes/CalcII/CrossProduct.aspx
    // v1=(a1, a2, a3) e v2=(b1, b2, b3) formula: a x b = (a2*b3-a3*b2, a3*b1-a1*b3, a1*b2-a2*b1)
    public static void cross(double[] a, double[] b, double[] r) {
        double a1 = a[0];
        double a2 = a[1];
        double a3 = a[2];
        double b1 = b[0];
        double b2 = b[1];
        double b3 = b[2];
        r[0] = a2 * b3 - a3 * b2;
        r[1] = a3 * b1 - a1 * b3;
        r[2] = a1 * b2 - a2 * b1;
    }

    // http://www.pontov.com.br/site/arquitetura/54-matematica-e-fisica/132-o-uso-de-vetores-nos-jogos
    // produto escalar (ou produto interno): http://www.somatematica.com.br/emedio/vetores/vetores6.php
    // http://www.mat.ufmg.br/~rodney/notas_de_aula/vetores.pdf
    // http://www.mathsisfun.com/algebra/vectors-dot-product.html
    public static double dot(double[] a, double[] b) {
        return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
    }

    // http://www.pontov.com.br/site/arquitetura/54-matematica-e-fisica/132-o-uso-de-vetores-nos-jogos
    public double relativeAngleBetween(double[] a, double[] b) {
        return (double) (Math.acos(dot(a, b) / (getSize(a) * getSize(b))));
    }

    // https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2drota.htm
    // https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2dconc.htm
    public static void rotateZ(double angle, double[] v) {
        double s = (double) Math.sin(angle);
        double c = (double) Math.cos(angle);
        double newX = v[0] * c - v[1] * s;
        double newY = v[0] * s + v[1] * c;
        v[0] = newX;
        v[1] = newY;
    }

    // nao testei
    // https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2dconc.htm
    public static void rotateX(double angle, double[] v) {
        double s = (double) Math.sin(angle);
        double c = (double) Math.cos(angle);
        double newY = v[1] * c - v[2] * s;
        double newZ = v[1] * s + v[2] * c;
        v[1] = newY;
        v[2] = newZ;
    }

    // nao testei
    // https://www.siggraph.org/education/materials/HyperGraph/modeling/mod_tran/2dconc.htm
    public static void rotateY(double angle, double[] v) {
        double s = (double) Math.sin(angle);
        double c = (double) Math.cos(angle);
        double newZ = v[2] * c - v[0] * s;
        double newX = v[2] * s + v[0] * c;
        v[2] = newZ;
        v[0] = newX;
    }

}
