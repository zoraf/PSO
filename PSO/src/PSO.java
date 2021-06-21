import java.util.List;
import org.apache.poi.*;
public class PSO {

    private String dataFileLocation = "E:\\Java\\Data 2018.xlsx";
    private List<Swarm> listOfSwarm;
    public static void main(String[]args){
        System.out.println("hello world");
        PSO pso = new PSO();
        pso.initParticles();
    }

    private void initParticles(){
        Particles particles = new Particles();
        particles.populateList(dataFileLocation);
    }

}
