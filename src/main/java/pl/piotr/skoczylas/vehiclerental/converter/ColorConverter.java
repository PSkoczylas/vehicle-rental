package pl.piotr.skoczylas.vehiclerental.converter;
import pl.piotr.skoczylas.vehiclerental.constant.Color;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color color) {
        return (color == null ? null : color.getShortName());
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        return (dbData == null ? null : Color.fromShortName(dbData));
    }
}
