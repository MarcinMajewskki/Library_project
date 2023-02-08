import org.example.library.ApplicationContext;
import org.example.library.api.RentedBooksData;
import org.example.library.dao.UserDao;
import org.example.library.dao.UserProvider;
import org.example.library.model.Rental;

import java.util.HashSet;
import java.util.Set;

public class RentalService {

    private final UserProvider userProvider;

    public RentalService() {
        this.userProvider = new UserDao();
    }

    public RentalService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public Set<RentedBooksData> getRentedBooksData() {
        Set<Rental> rentals = userProvider
                .findUserByLogin(ApplicationContext.getActiveUser().getLogin()).get().getRentals();
        Set<RentedBooksData> rentedBooksData = new HashSet<>();
        for (Rental rental : rentals) {
            rentedBooksData.add(new RentedBooksData(
                    rental.getBook().getTitle()
                    , rental.getRentDate()
                    , rental.getDueDate()));
        }
        return rentedBooksData;
    }
}
