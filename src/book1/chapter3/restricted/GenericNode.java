package book1.chapter3.restricted;

public interface GenericNode
{  public abstract GenericNode deepCopy(); // clones the invoking object
    public abstract String toString(); // added to prevent Object’s toString method from
                                         // executing. Technically not syntactically necessary.
}

