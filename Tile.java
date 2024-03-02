public abstract class Tile {
    private String icon;

    /**
     * This is the constructor for a class tile. It takes in a 
     * String called Icon and assigns it to the icon attribute.
     * @param icon
     */
    public Tile(String icon) {
        this.icon = icon;
    }

    /**
     * This method gets/returns the Icon from the icon attribute.
     * 
     * @return Icon - A string
     */
    public String getIcon() {
        return icon;
    }
}
