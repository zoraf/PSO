import java.util.List;
import org.apache.poi.*;
public class PSO {

    private static String dataFileLocation = "E:\\Java\\Data 2018.xlsx";
    private List<Swarm> listOfSwarm;
    public static void main(String[]args){
        System.out.println("hello world");
        Particles particles = new Particles();
        particles.populateList(dataFileLocation);
        particles.showList();

    }
}
