import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Particles {
    private List<Swarm> listOfSwarms;

    public Particles() {
        this.listOfSwarms = new ArrayList<Swarm>();
    }

    public Particles(List<Swarm> listOfSwarms) {
        this.listOfSwarms = listOfSwarms;
    }

    public void populateList(String fileLocation) {
        try {
            File file = new File(fileLocation);
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                int counter = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (counter == 5) {
                        Swarm swarm = new Swarm();
                        swarm.setX(Double.parseDouble(cell.getStringCellValue()));
                        swarm.setY(Utils.Y);
                        swarm.setBestKnownX(swarm.getX());
                        listOfSwarms.add(swarm);
                    }
                    counter++;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Swarm> getListOfSwarms() {
        return listOfSwarms;
    }

    public void setListOfSwarms(List<Swarm> listOfSwarms) {
        this.listOfSwarms = listOfSwarms;
    }


    public double calculateSD(){
        double sum = 0;
        for (int i =0; i< listOfSwarms.size(); i++){
            sum += listOfSwarms.get(i).getX();
        }

        double mean = sum / listOfSwarms.size();

        double deviation = 0;
        for (int i=0; i<listOfSwarms.size();i++){
            deviation += (listOfSwarms.get(i).getX() - mean) * (listOfSwarms.get(i).getX() - mean);
        }
        double stantdardDeviation = Math.sqrt(deviation/listOfSwarms.size());
        return stantdardDeviation;
    }
    public void showList(){
        try{
            System.out.println("Size ::  " +listOfSwarms.size());
            for (int i=0 ; i<listOfSwarms.size(); i++){
                Swarm swarm = listOfSwarms.get(i);
                System.out.println("X:: " + swarm.getX() + "  Y:: " + swarm.getY()
                        + "  BN::  "+swarm.getBestKnownX());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
