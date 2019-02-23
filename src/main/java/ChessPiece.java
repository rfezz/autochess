import java.io.Serializable;

public class ChessPiece implements Serializable {

    private long serialVersionUID = 1;

    private String name;
    private String species1;
    private String species2;
    private String job;
    private int cost;


    public ChessPiece(String name, String species1, String species2, String job, int cost) {
        this.name = name;
        this.species1 = species1;
        this.species2 = species2;
        this.job = job;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }

    public String getSpecies1() {
        return species1;
    }

    public String getSpecies2() {
        return species2;
    }

    public String getJob() {
        return job;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "name='" + name + '\'' +
                ", species1='" + species1 + '\'' +
                ", species2='" + species2 + '\'' +
                ", class='" + job + '\'' +
                ", cost=" + cost +
                '}';
    }
}



