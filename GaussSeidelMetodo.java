package Ecuaciones_lineales.Gauss_Seidel;

// Importamos la función calcularError desde Jacobi
import static Ecuaciones_lineales.JACOBI.MetodoJacobi.calcularError;

public class GaussSeidelMetodo {

    public static double[] gaussSeidel(double[][] A, double[] b,
                                        double[] xInicial, double tol, int maxIter) {
        int n = xInicial.length;
        double[] x = xInicial.clone(); // Vector que se actualiza en el momento

        System.out.println("\n=== MÉTODO DE GAUSS-SEIDEL ===");
        System.out.printf("%-5s %-12s %-12s %-12s %-12s%n", 
                          "Iter", "x1", "x2", "x3", "Error");
        System.out.println("-------------------------------------------------------");

        for (int iter = 0; iter < maxIter; iter++) {
            double[] xAnt = x.clone(); // Guardamos valores anteriores para el error

            for (int i = 0; i < n; i++) {
                double suma = b[i]; // Empieza con el término independiente

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        // ✅ Completado: usa valores ya actuales en la misma iteración
                        suma -= A[i][j] * x[j];
                    }
                }
                // ✅ Completado: calcula el nuevo valor de x[i]
                x[i] = suma / A[i][i];
            }

            double error = calcularError(xAnt, x);
            System.out.printf("%-5d %-12.6f %-12.6f %-12.6f %-12.6f%n",
                             iter + 1, x[0], x[1], x[2], error);

            // ✅ Completado: verifica convergencia
            if (error < tol) {
                System.out.println("-------------------------------------------------------");
                System.out.println("✅ Convergencia alcanzada en " + (iter + 1) + " iteraciones\n");
                return x;
            }
        }

        System.out.println("⚠️ Se alcanzó el máximo de iteraciones sin convergencia\n");
        return x;
    }
}
