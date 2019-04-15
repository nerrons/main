package seedu.hms.logic.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import seedu.hms.commons.core.LogsCenter;
import seedu.hms.commons.core.index.Index;
import seedu.hms.logic.stats.statsitems.CountPayersForReservations;
import seedu.hms.logic.stats.statsitems.CountPayersForServices;
import seedu.hms.logic.stats.statsitems.CountRoomTypes;
import seedu.hms.logic.stats.statsitems.CountServiceTypes;
import seedu.hms.logic.stats.statsitems.StatsItem;
import seedu.hms.model.ReadOnlyHotelManagementSystem;

/**
 * Provide stats for a specific hms
 */
public class Stats {
    private static final Logger logger = LogsCenter.getLogger(Stats.class);
    private final ReadOnlyHotelManagementSystem hms;
    private final ArrayList<StatsItem> statsitems;
    private ArrayList<Index> shown;

    public Stats(ReadOnlyHotelManagementSystem hms) {
        this.hms = hms;
        this.statsitems = new ArrayList<>(Arrays.asList(
                new CountRoomTypes(this),
                new CountServiceTypes(this),
                new CountPayersForReservations(this),
                new CountPayersForServices(this)
        ));

        this.shown = new ArrayList<>();
        List<Integer> defaultShown = IntStream.range(0, 4).boxed().collect(Collectors.toList());
        defaultShown.forEach(n -> shown.add(Index.fromZeroBased(n)));
    }

    private static String fillOnLeft(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    /**
     * Generate a text report for all the StatsItems.
     * @return A string of the text report.
     */
    public String toTextReport() {
        final StringBuilder sb = new StringBuilder();
        for (Index i : shown) {
            StatsItem si = statsitems.get(i.getZeroBased());
            sb.append("*** " + si.getTitle() + "\n");
            sb.append(si.toTextReport());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Update all StatsItems.
     */
    public void update() {
        for (StatsItem si : statsitems) {
            si.updateMap();
        }
    }

    public ReadOnlyHotelManagementSystem getHms() {
        return hms;
    }

    public List<StatsItem> getStatsitems() {
        return statsitems;
    }
}