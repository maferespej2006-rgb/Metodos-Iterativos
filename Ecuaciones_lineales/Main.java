package Ecuaciones_lineales;

import Ecuaciones_lineales.JACOBI.MetodoJacobi;
import Ecuaciones_lineales.Gauss_Seidel.GaussSeidelMetodo;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  PRÁCTICA: MÉTODOS ITERATIVOS EN JAVA");
        System.out.println("  Jacobi vs Gauss-Seidel");
        System.out.println("==============================================\n");

        // Sistema de ecuaciones:
        // 5x +  y + z = 7
        //  x + 4y + z = 6
        //  x + 2y +5z = 8

        double[][] A = {
            {5, 1, 1},
            {1, 4, 1},
            {1, 2, 5}
        };

        double[] b = {7, 6, 8};
        double[] xInicial = {0, 0, 0};
        double tolerancia = 0.0001;
        int maxIteraciones = 100;

        // Ejecutar Método de Jacobi
        double[] solucionJacobi = MetodoJacobi.jacobi(A, b, xInicial, tolerancia, maxIteraciones);
        System.out.printf("Solución final: x = %.6f, y = %.6f, z = %.6f%n",
                         solucionJacobi[0], solucionJacobi[1], solucionJacobi[2]);

        // Ejecutar Método de Gauss-Seidel
        double[] solucionGauss = GaussSeidelMetodo.gaussSeidel(A, b, xInicial, tolerancia, maxIteraciones);
        System.out.printf("Solución final: x = %.6f, y = %.6f, z = %.6f%n",
                         solucionGauss[0], solucionGauss[1], solucionGauss[2]);

        System.out.println("==============================================");
        System.out.println("       FIN DE LA EJECUCIÓN");
        System.out.println("==============================================");
    }
}
