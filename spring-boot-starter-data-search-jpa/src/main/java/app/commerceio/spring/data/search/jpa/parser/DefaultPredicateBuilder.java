package app.commerceio.spring.data.search.jpa.parser;

public class DefaultPredicateBuilder implements PredicateBuilder<String> {

    @Override
    public String parse(String value) {
        return value;
    }
}
