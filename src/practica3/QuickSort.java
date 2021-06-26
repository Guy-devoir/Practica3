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
    static int[] contador = new int[10];

    public QuickSort(DefaultCategoryDataset chartContent,String title,int[] contador){
        super(createChart(chartContent,title, contador));   
    }   
       
    private static JFreeChart createChart(DefaultCategoryDataset chartContent, String title, int[] contador) {
        //Create a sequence diagram object   
        QuickSort.contador = contador;
        QuickSort.dataset = chartContent;
        _grafico = ChartFactory.createBarChart(title, "EDADES", "# DE ALUMNOS", chartContent, PlotOrientation.VERTICAL, false, false, false);
        return _grafico;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                quickSort(contador, 0, contador.length - 1);                

                if (contador[0] != 0) {
                    dataset.setValue(contador[0], "Edades", "10");
                }
                if (contador[1] != 0) {
                    dataset.setValue(contador[1], "Edades", "20");
                }
                if (contador[2] != 0) {
                    dataset.setValue(contador[2], "Edades", "30");
                }
                if (contador[3] != 0) {
                    dataset.setValue(contador[3], "Edades", "40");
                }
                if (contador[4] != 0) {
                    dataset.setValue(contador[4], "Edades", "50");
                }
                if (contador[5] != 0) {
                    dataset.setValue(contador[5], "Edades", "60");
                }
                if (contador[6] != 0) {
                    dataset.setValue(contador[6], "Edades", "70");
                }
                if (contador[7] != 0) {
                    dataset.setValue(contador[7], "Edades", "80");
                }
                if (contador[8] != 0) {
                    dataset.setValue(contador[8], "Edades", "90");
                }
                if (contador[9] != 0) {
                    dataset.setValue(contador[9], "Edades", "100");
                }
                repaint();               
                
            } catch (InterruptedException e) {
            }
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            System.out.println(arr[0]);
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            /*if (arr[0] != 0) {
                dataset.setValue(arr[0], "Edades", "10");
            }
            if (arr[1] != 0) {
                dataset.setValue(arr[1], "Edades", "20");
            }
            if (arr[2] != 0) {
                dataset.setValue(arr[2], "Edades", "30");
            }
            if (arr[3] != 0) {
                dataset.setValue(arr[3], "Edades", "40");
            }
            if (arr[4] != 0) {
                dataset.setValue(arr[4], "Edades", "50");
            }
            if (arr[5] != 0) {
                dataset.setValue(arr[5], "Edades", "60");
            }
            if (arr[6] != 0) {
                dataset.setValue(arr[6], "Edades", "70");
            }
            if (arr[7] != 0) {
                dataset.setValue(arr[7], "Edades", "80");
            }
            if (arr[8] != 0) {
                dataset.setValue(arr[8], "Edades", "90");
            }
            if (arr[9] != 0) {
                dataset.setValue(arr[9], "Edades", "100");
            }
            repaint();
*/
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
