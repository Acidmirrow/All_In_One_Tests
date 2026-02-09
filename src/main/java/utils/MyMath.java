package utils;

// --------------   MyMath.java   --------------

/**
 * Утилита с некоторыми статическими методами для демонстрации целей тестов.
 * <p>
 * Его нельзя случайно запутать с {@code Math} — стандартным классом JDK.
 * Простой «обёртка/помощник», чтобы имитировать реальные вычисления
 * в ваших тестах.
 */
public final class MyMath {

    /** Непубличный конструктор – класс содержит только статические методы. */
    private MyMath() { }

    /**
     * Сложение двух целых чисел.
     *
     * @param a первый операнд
     * @param b второй операнд
     * @return a + b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Показатель Фибоначчи: 0 → 0, 1 → 1, 2 → 1, 3 → 2, …
     * Операция O(n) (простой, но не самый быстрый способ).
     *
     * @param n номер в последовательности
     * @return n‑й член Фибоначчи
     * @throws IllegalArgumentException если n < 0
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non‑negative");
        }
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        long a = 0L, b = 1L;
        for (long i = 2; i <= n; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    /**
     * Наибольший общий делитель двух целых чисел (Алгоритм Эвклида).
     *
     * @param a первое число
     * @param b второе число
     * @return НОД
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

}
