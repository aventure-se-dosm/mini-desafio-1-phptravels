package core.dataProviders;

public interface DataMethods<T extends Enum<?>> {
    String searchForIndex(String id);

    String searchForAttribute(T attribute, String value);
}
