package pl.piotr.skoczylas.vehiclerental.constant

import spock.lang.Specification
import spock.lang.Subject

import java.sql.Date
import java.time.LocalDate

class ConvertLocalDateToSQLDateSpec extends Specification {
    @Subject
    def convertLocalDateToSQLDate = new ConvertLocalDateToSQLDate()

    def "should convert to database column"() {
        expect:
            convertLocalDateToSQLDate.convertToDatabaseColumn(localDate) == date
        where:
            localDate                                           || date
            new LocalDate(2012, 12, 21) || Date.valueOf("2012-12-21")
            new LocalDate(1929, 5, 4)   || Date.valueOf("1929-05-04")
            new LocalDate(2111, 2, 1)   || Date.valueOf("2111-02-01")
            null                                                 || null
    }

    def "should convert to entity attribute"() {
        expect:
            convertLocalDateToSQLDate.convertToEntityAttribute(date) == localDate
        where:
        date                          || localDate
        Date.valueOf("2012-12-21") || new LocalDate(2012, 12, 21)
        Date.valueOf("1929-05-04") || new LocalDate(1929, 5, 4)
        Date.valueOf("2222-10-02") || new LocalDate(2222, 10, 02)
        null                          || null

    }

}
