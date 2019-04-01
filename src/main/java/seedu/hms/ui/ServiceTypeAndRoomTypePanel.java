package seedu.hms.ui;

import java.util.function.Consumer;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * The ServiceTypeAndRoomType Panel of the App.
 */
public class ServiceTypeAndRoomTypePanel extends UiPart<Region> {
    private static final String FXML = "ServiceTypeAndRoomTypePanel.fxml";

    private final Consumer<Integer> onSelectedTabChange;

    @FXML
    private StackPane serviceTypeListPanelPlaceholder;

    @FXML
    private StackPane roomTypeListPanelPlaceholder;

    @FXML
    private TabPane tabPane;

    public ServiceTypeAndRoomTypePanel(ServiceTypeListPanel serviceTypeListPanel, RoomTypeListPanel roomTypeListPanel,
                                       ObservableValue<Integer> selectedTabIndex,
                                       Consumer<Integer> onSelectedTabChange) {
        super(FXML);
        System.out.println(tabPane);
        selectedTabIndex.addListener(((observable, oldValue, newValue) -> {
            tabPane.getSelectionModel().select(newValue);
        }));
        this.onSelectedTabChange = onSelectedTabChange;
        serviceTypeListPanelPlaceholder.getChildren().add(serviceTypeListPanel.getRoot());
        roomTypeListPanelPlaceholder.getChildren().add(roomTypeListPanel.getRoot());
    }
}
