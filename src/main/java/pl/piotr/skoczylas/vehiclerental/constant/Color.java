package pl.piotr.skoczylas.vehiclerental.constant;

public enum Color {
    RED("R"),
    GREEN("G"),
    BLUE("B");

    private String color;

    private Color(String color) {
        this.color = color;
    }

    public String getShortName() {
        return color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Color fromShortName(String color) {
        switch(color) {
            case "B":
                return Color.BLUE;

            case "R":
                return Color.RED;

            case "G":
                return Color.GREEN;

            default:
                throw new IllegalArgumentException("ShortName [" + color
                        + "] not supported.");
        }
    }
}
