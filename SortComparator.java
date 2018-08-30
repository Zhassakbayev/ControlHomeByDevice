package Task2;

import java.util.Comparator;

public class SortComparator implements Comparator<Device> {
    @Override
    public int compare(Device sort1, Device sort2) {
                return sort1.getPower()-sort2.getPower();
    }


}
