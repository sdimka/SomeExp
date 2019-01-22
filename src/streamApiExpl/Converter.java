package streamApiExpl;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F f);
}
