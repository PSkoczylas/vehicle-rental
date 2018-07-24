package pl.piotr.skoczylas.vehiclerental.constant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConvertLocalDateToSQLDateTest {
    ConvertLocalDateToSQLDate convertLocalDateToSQLDate;

    @Before
    public void setUp() {
        convertLocalDateToSQLDate = new ConvertLocalDateToSQLDate();
    }

    @Test
    public void convertLocalDateToSQLDate() {
        assertEquals(convertLocalDateToSQLDate.convertToDatabaseColumn(LocalDate.of(2012, 10, 21)), Date.valueOf("2012-10-21"));
        assertEquals(convertLocalDateToSQLDate.convertToDatabaseColumn(null), null);
    }

    @Test
    public void convertSQLDateToLocalDate() {
        assertEquals(convertLocalDateToSQLDate.convertToEntityAttribute(Date.valueOf("1999-01-30")), LocalDate.of(1999,01,30));
        assertEquals(convertLocalDateToSQLDate.convertToEntityAttribute(null), null);
    }

}
