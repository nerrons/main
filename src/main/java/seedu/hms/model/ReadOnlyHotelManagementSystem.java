package seedu.hms.model;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import seedu.hms.model.booking.Booking;
import seedu.hms.model.booking.ServiceType;
import seedu.hms.model.customer.Customer;

/**
 * Unmodifiable view of an hms book
 */
public interface ReadOnlyHotelManagementSystem extends Observable {

    /**
     * Returns an unmodifiable view of the customers list.
     * This list will not contain any duplicate customers.
     */
    ObservableList<Customer> getCustomerList();

    /**
     * Returns an unmodifiable view of the bookings list.
     */
    ObservableList<Booking> getBookingList();

    /**
     * Returns an unmodifiable view of the bookings list.
     */
    ObservableList<ServiceType> getServiceTypeList();
}
