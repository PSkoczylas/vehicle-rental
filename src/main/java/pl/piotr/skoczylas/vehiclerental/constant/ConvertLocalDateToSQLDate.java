package pl.piotr.skoczylas.vehiclerental.constant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.sql.Date;

@Converter(autoApply = true)
public class ConvertLocalDateToSQLDate implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
