public class Property <T> {

    /// fields

    private T value;
    private Object owner;

    /// Class methods
    public Property(Object owner, T initialValue) {
        value = initialValue;
        this.owner = owner;
    }

    public Object getOwner(){

    }

    public T get(){

    }

    public void set(T newValue) {

    }

    public void addListener(Property<T> listener) {

    }

    public void addListeners(Property<T> ... listeners) {

    }

    public void removeListener(Property<T> listener) {

    }

    protected void notifyListeners() {

    }

    /// interface methods


}
