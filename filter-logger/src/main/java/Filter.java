import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer i : source) {
            if (i < threshold) {
                logger.log("Число \"" + i + "\" не проходит");
            } else {
                result.add(i);
                logger.log("Число \"" + i + "\" проходит");
            }
        }
        return result;
    }
}
