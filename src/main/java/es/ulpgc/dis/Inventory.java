package es.ulpgc.dis;

public class Inventory {

    @ScrewFactory(material = "steel", weight = 4)
    private int tirafondo;
    @ScrewFactory(material = "iron", weight = 6)
    private int screws;
    @Tool(insulation = true)
    private int screwdrivers;

    public Inventory(int tirafondo, int screws, int screwdrivers) {
        this.tirafondo = tirafondo;
        this.screws = screws;
        this.screwdrivers = screwdrivers;
    }
}
