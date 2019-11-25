import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.NamedPlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;

import java.util.ArrayList;

public class Plot {
    JavaPlot p = new JavaPlot();

    public void plot(ArrayList<ComplexNum> vertices, String title) {
        int size = vertices.size();

        PlotStyle myPlotStyle = new PlotStyle();
        myPlotStyle.setStyle(Style.LINESPOINTS);
        myPlotStyle.setLineWidth(1);
        myPlotStyle.setLineType(NamedPlotColor.RED);
        myPlotStyle.setPointType(7);
        myPlotStyle.setPointSize(1);

        double tab[][] = new double[size + 1][size + 1];

        for (int i = 0; i < size; i++) {
            tab[i][0] = vertices.get(i).getReal();
            tab[i][1] = vertices.get(i).getImg();
        }

        tab[size][0] = vertices.get(0).getReal();
        tab[size][1] = vertices.get(0).getImg();

        DataSetPlot s = new DataSetPlot(tab);
        s.setTitle(title);
        s.setPlotStyle(myPlotStyle);

        p.newGraph();
        p.addPlot(s);
        p.newGraph();
        p.plot();

    }

}
