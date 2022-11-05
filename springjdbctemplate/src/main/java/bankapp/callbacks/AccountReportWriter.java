package bankapp.callbacks;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountReportWriter implements RowCallbackHandler {

    @Override
    public void processRow(ResultSet resultSet) throws SQLException {
        // parse current row from ResultSet and stream to output
    }

}
