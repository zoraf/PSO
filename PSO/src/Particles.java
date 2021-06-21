import java.util.List;

public class Particles {
    private List<Swarm> listOfSwarms;

    public Particles() {

    }

    public Particles(List<Swarm> listOfSwarms) {
        this.listOfSwarms = listOfSwarms;
    }

    public void populateList(String fileLocation){

    }
    public List<Swarm> getListOfSwarms() {
        return listOfSwarms;
    }

    public void setListOfSwarms(List<Swarm> listOfSwarms) {
        this.listOfSwarms = listOfSwarms;
    }
}
