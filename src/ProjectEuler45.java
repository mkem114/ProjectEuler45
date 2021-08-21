import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ProjectEuler45 {
    public static void main(String[] args) {
        final long START = 1L;
        final long LIMIT = 300_000L;

        List<Long> range = LongStream.rangeClosed(START, LIMIT)
                .boxed()
                .collect(Collectors.toList());

        final Set<Long> triangleNumbers = range.stream()
                .map(number -> number * (number + 1) / 2)
                .collect(Collectors.toSet());

        final Set<Long> pentagonalNumbers = range.stream()
                .map(number -> number * (3*number - 1) / 2)
                .collect(Collectors.toSet());

        final Set<Long> hexagonalNumbers = range.stream()
                .map(number -> number * (2*number - 1))
                .collect(Collectors.toSet());

        final List<Long> matches = hexagonalNumbers.stream()
                .filter(pentagonalNumbers::contains)
                .filter(triangleNumbers::contains)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(matches);
    }
}
