package lab3.annimals;

public abstract class Chordal {

    protected String type;

    public Chordal()
    {
        type = "Chordal";
    }

    @Override
    public String toString()
    {
        return type;
    }
}
