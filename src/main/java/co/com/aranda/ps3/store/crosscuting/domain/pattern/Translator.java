package co.com.aranda.ps3.store.crosscuting.domain.pattern;

/**
 * The Interface Translator.
 *
 * @param <I> the generic type
 * @param <O> the generic type
 */
public interface Translator<I, O> {
    I translateToEntity(final O input);
    O translateToDto(final I input);


}
