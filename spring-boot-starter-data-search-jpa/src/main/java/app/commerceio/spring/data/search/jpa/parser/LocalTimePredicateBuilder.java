package app.commerceio.spring.data.search.jpa.parser;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalTime;

public class LocalTimePredicateBuilder implements PredicateBuilder<LocalTime> {

    @Override
    public LocalTime parse(String value) {
        try {
            return LocalTime.parse(value);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    @Override
    public Predicate gt(Path<?> path, String key, String value, CriteriaBuilder criteriaBuilder) {
        LocalTime localTime = parse(value);
        return criteriaBuilder.greaterThan(path.get(key), localTime);
    }

    @Override
    public Predicate ge(Path<?> path, String key, String value, CriteriaBuilder criteriaBuilder) {
        LocalTime localTime = parse(value);
        return criteriaBuilder.greaterThanOrEqualTo(path.get(key), localTime);
    }

    @Override
    public Predicate lt(Path<?> path, String key, String value, CriteriaBuilder criteriaBuilder) {
        LocalTime localTime = parse(value);
        return criteriaBuilder.lessThan(path.get(key), localTime);
    }

    @Override
    public Predicate le(Path<?> path, String key, String value, CriteriaBuilder criteriaBuilder) {
        LocalTime localTime = parse(value);
        return criteriaBuilder.lessThanOrEqualTo(path.get(key), localTime);
    }
}
