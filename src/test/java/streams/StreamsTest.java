package streams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.MyMath;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamsTest {

    @Test
    @DisplayName("Проверка четности всех значений через Stream Api")
    public void streamsEvenNumbersTest() {
        List<Integer> numbers = List.of(2, 4, 6, 8, 10);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);

        assertTrue(allEven, "Всё должно быть чётным");
    }

    @Test
    @DisplayName("Проверка разбивки массива имён через Stream Api")
    public void partitionByNameLength() {
        List<String> names = List.of("Sam", "Alex", "Jo", "Kate", "Bob");
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(Collectors.partitioningBy(n -> n.length() > 3));

        assertEquals(
                List.of("alex", "kate"),
                partitioned.get(true).stream()
                        .map(String::toLowerCase)
                        .sorted()
                        .toList()
        );
        assertEquals(
                List.of("sam", "jo", "bob"),
                partitioned.get(false).stream()
                        .map(String::toLowerCase)
                        .toList()
        );
    }

    @Test
    void testImmutableListCollector() {
        List<String> sorted = Stream.of("d", "b", "a", "c")
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        l -> {
                            Collections.sort(l);
                            return List.copyOf(l);      // immutable
                        }
                ));

        assertEquals(List.of("a","b","c","d"), sorted);
        assertThrows(UnsupportedOperationException.class, () -> sorted.add("e"));
    }

    @Test
    public void uniqueIPs() {
        List<String> ips = List.of(
                "192.168.0.1", "192.168.0.2",
                "192.168.0.1", "192.168.0.3",
                "192.168.0.2"
        );

        long duplicateCount = ips.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(count -> count > 1)
                .count();

        assertEquals(2, duplicateCount, "Должно быть 2 IP‑ов, встречающихся более одного раза");
    }


    @ParameterizedTest(name = "Sum of {0} and {1} equals {2}")
    @MethodSource("sumProvider")
    void sumTest(int a, int b, int expectedSum) {
        assertEquals(expectedSum, MyMath.add(a, b));
    }

    static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(-1, 7, 6),
                Arguments.of(0, 0, 0)
        );
    }

    @Test
    @DisplayName("Проверка расчета средней суммы чисел через Stream Api")
    public void averageSum () {
        int[] arr = {1, 2, 3, 4, 5};
        double avg = Arrays.stream(arr).average()
                .orElseThrow(() -> new IllegalStateException("Empty array"));
        assertEquals(3,avg);
    }
}

