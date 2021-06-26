package practica3;

import GUI.Directorio;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Luciano Xiquín
 */
    
import org.jfree.chart.ChartFactory;   
import org.jfree.chart.ChartPanel;   
import org.jfree.chart.JFreeChart;   
import org.jfree.chart.axis.ValueAxis;   
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;   
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Millisecond;   
import org.jfree.data.time.TimeSeries;   
import org.jfree.data.time.TimeSeriesCollection;   
   
public class QuickSort extends ChartPanel implements Runnable{            
    static DefaultCategoryDataset dataset;
    private static JFreeChart _grafico;
    static int[] contador;

    public QuickSort(DefaultCategoryDataset chartContent,String title){
        super(createChart(chartContent,title));   
    }   
       
    private static JFreeChart createChart(DefaultCategoryDataset chartContent, String title) {
        //Create a sequence diagram object   
        
        QuickSort.dataset = chartContent;
        _grafico = ChartFactory.createBarChart(title, "EDADES", "# DE ALUMNOS", chartContent, PlotOrientation.VERTICAL, false, false, false);
        return _grafico;
    }

    public void run() {
        while (true) {
            try {  
               // dataset.setValue(WIDTH, WIDTH, PROPERTIES);
                //dataset.setValue(WIDTH, WIDTH, PROPERTIES);
               // dataset.setValue(WIDTH, WIDTH, PROPERTIES);
                
                repaint();
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        dataset.getValue(low, low);
        dataset.getValue(low, low);
    }

    private static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
