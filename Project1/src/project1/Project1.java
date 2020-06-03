
//=============================================================================
// PROGRAMMER: Ray West
// PANTHER ID: 6229213
//
// CLASS: COP3337
// SECTION: Your class section: RVDC 1205
// SEMESTER: The current semester: Summer 2020
// CLASSTIME: TH 10:00-11:15 am
//
// Project: Put what this project is: Project 1
// DUE: 5/24/2020
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this 
//                work is my own and that none of it is the work of any other person.
//=============================================================================

package project1;

//--------------------------------------------------
// Imports
//--------------------------------------------------
import java.io.*;
import java.util.*;


public class Project1 {

   
    public static void main(String[] args) {
        
        // The name of the file to open.
        // notice that the StockPrice_X_Data.txt is in the data package
        String fileName = "src/data/Stock_Data.txt";

        // This will reference one line at a time
        String line = null;
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =  new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            
           //PUT CODE HERE
           
           //Create various ArrayLists containing doubles for each stock price
           ArrayList<Double> x_stockPrices = new ArrayList<Double>();
           ArrayList<Double> ge_stockPrices = new ArrayList<Double>();
           ArrayList<Double> appl_stockPrices = new ArrayList<Double>();
           ArrayList<Double> goog_stockPrices = new ArrayList<Double>();
           ArrayList<Double> f_stockPrices = new ArrayList<Double>();
           
           //Create various ArrayLists containing doubles for each correlation
           ArrayList<Double> xCorrelations = new ArrayList<Double>();
           ArrayList<Double> geCorrelations = new ArrayList<Double>();
           ArrayList<Double> applCorrelations = new ArrayList<Double>();
           ArrayList<Double> googCorrelations = new ArrayList<Double>();
           ArrayList<Double> fCorrelations = new ArrayList<Double>();
           
           //Create ArrayList containing an ArrayList containing a double
           ArrayList<ArrayList<Double>> correlationMatrix = new ArrayList<ArrayList<Double>>();
           
           //Read line to skip heading in txt file
           bufferedReader.readLine();
           
           //bufferedReader to readLine of Stock_Data.txt, loop through txt file line by line
           while ((line = bufferedReader.readLine()) != null) {
                //Split txt data by comma
                String[] lineColumn = line.split(",");
                
                //On each loop, add double at specified index starting with 1 to skip date column
                x_stockPrices.add(Double.parseDouble(lineColumn[1]));
                ge_stockPrices.add(Double.parseDouble(lineColumn[2]));
                appl_stockPrices.add(Double.parseDouble(lineColumn[3]));
                goog_stockPrices.add(Double.parseDouble(lineColumn[4]));
                f_stockPrices.add(Double.parseDouble(lineColumn[5]));
                
            }

            // Always close files.
            bufferedReader.close(); 

            //------------------------------------------------------------------
            // Doing some calculations
            //------------------------------------------------------------------
            
			//PUT CODE HERE
           
           //Add data returned in findCorrelations method to corresponding ArrayList
           xCorrelations.add(findCorrelation(x_stockPrices,x_stockPrices));
           xCorrelations.add(findCorrelation(x_stockPrices,ge_stockPrices));
           xCorrelations.add(findCorrelation(x_stockPrices,appl_stockPrices));
           xCorrelations.add(findCorrelation(x_stockPrices,goog_stockPrices));
           xCorrelations.add(findCorrelation(x_stockPrices,f_stockPrices));
           
           geCorrelations.add(findCorrelation(ge_stockPrices,x_stockPrices));
           geCorrelations.add(findCorrelation(ge_stockPrices,ge_stockPrices));
           geCorrelations.add(findCorrelation(ge_stockPrices,appl_stockPrices));
           geCorrelations.add(findCorrelation(ge_stockPrices,goog_stockPrices));
           geCorrelations.add(findCorrelation(ge_stockPrices,f_stockPrices));
           
           applCorrelations.add(findCorrelation(appl_stockPrices,x_stockPrices));
           applCorrelations.add(findCorrelation(appl_stockPrices,ge_stockPrices));
           applCorrelations.add(findCorrelation(appl_stockPrices,appl_stockPrices));
           applCorrelations.add(findCorrelation(appl_stockPrices,goog_stockPrices));
           applCorrelations.add(findCorrelation(appl_stockPrices,f_stockPrices));
           
           googCorrelations.add(findCorrelation(goog_stockPrices,x_stockPrices));
           googCorrelations.add(findCorrelation(goog_stockPrices,ge_stockPrices));
           googCorrelations.add(findCorrelation(goog_stockPrices,appl_stockPrices));
           googCorrelations.add(findCorrelation(goog_stockPrices,goog_stockPrices));
           googCorrelations.add(findCorrelation(goog_stockPrices,f_stockPrices));
           
           fCorrelations.add(findCorrelation(f_stockPrices,x_stockPrices));
           fCorrelations.add(findCorrelation(f_stockPrices,ge_stockPrices));
           fCorrelations.add(findCorrelation(f_stockPrices,appl_stockPrices));
           fCorrelations.add(findCorrelation(f_stockPrices,goog_stockPrices));
           fCorrelations.add(findCorrelation(f_stockPrices,f_stockPrices));
           
           //Add each correlations ArrayList to correlationMatrix ArrayList
           correlationMatrix.add(xCorrelations);
           correlationMatrix.add(geCorrelations);
           correlationMatrix.add(applCorrelations);
           correlationMatrix.add(googCorrelations);
           correlationMatrix.add(fCorrelations);
           
           //Print each ArrayList from correlationMatrix line by line
           for(ArrayList<Double> d : correlationMatrix){
               System.out.println(d);
           }
           
        // handle errors if they arise
        } catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        } catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }//end try

      
    }// end main()
    
//------------------------------------------------------------------------------
// helper functions/
//------------------------------------------------------------------------------
    
    public static double findAverage(ArrayList<Double> prices){
        
        double average = 0.0;
        int n = prices.size();
	//PUT CODE HERE
        
        //Loop through array itmes, add each number to sum, divide by n, return average
        double sum = 0.0;
        for (int i = 0; i < n; i++){
            sum += prices.get(i);
        }
        average = sum/n;   
           
       return average;
    }//end findAverage()
    
    //--------------------------------------------------------------------------
    public static double findStandardDeviation(ArrayList<Double> prices){
        
 	//PUT CODE HERE
        double stdDev = 0.0;
        int n = prices.size();
	double avg = findAverage(prices);
        double sum = 0;
        
        //Use previously found average, loop through array items, take price - avg and get the sqrt for stdDev
        for (int i = 0; i < n; i++){
            double distanceSq = Math.pow(prices.get(i) - avg, 2);
            sum += distanceSq;
        }     
        
        stdDev = Math.sqrt(sum / (n - 1));
        return stdDev;
    }

    //--------------------------------------------------------------------------
    
    public static double findCorrelation(ArrayList<Double> firstPrices, ArrayList<Double> secondPrices ){
        
        double correlation = 0.0 ;
       
        //PUT CODE HERE
        
        double sum = 0.0;
        int n = firstPrices.size();
        double n2 = firstPrices.size();
        double avgX = findAverage(firstPrices);
        double avgY = findAverage(secondPrices);
        double stdvX = findStandardDeviation(firstPrices);
        double stdvY = findStandardDeviation(secondPrices);
        
        //Use avg and stdDev to calculate correlation based on two arguments, each being an ArrayList of doubles (stockPrices)
        for (int i = 0; i < n; i++){
            sum += (firstPrices.get(i) - avgX) * (secondPrices.get(i) - avgY);
        }
        correlation = round(((sum / (stdvX * stdvY) * (1/(n2-1)))), 2);
        
       return correlation;
    }//end findCorrelation()
    
    
    public static double round(double value, int places){
        if (places < 0 ) throw new IllegalArgumentException();
        
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
}
