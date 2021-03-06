package ru.concerteza.util.namedregex.function;

import com.google.common.base.Predicate;
import ru.concerteza.util.namedregex.NamedMatcher;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Guava predicate, checks whether {@link NamedMatcher} matches. May be used with {@link NamedRegexFunction}
 *
 * @author  alexey
 * Date: 2/9/12
 * @see NamedRegexFunction
 * @see ru.concerteza.util.namedregex.NamedPattern
 */
@Deprecated // use com.github.tony19:named-regexp
public class NamedRegexPredicate implements Predicate<NamedMatcher> {
    /**
     * @param input {@link NamedMatcher}
     * @return result of <code>input.matches()</code>
     */
    @Override
    public boolean apply(@Nullable NamedMatcher input) {
        checkNotNull(input);
        return input.matches();
    }
}
