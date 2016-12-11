package edu.illinois.adsc;

/**
 * Created by Robert on 12/11/16.
 */
public class City {
    private double x1,x2,x3,x4;
    private int partitions;
    private RangePartition xRangePartition;
    private RangePartition yRangePartition;
    ZOrderCoding zOrderCoding;
    public City(double x1, double x2, double y1, double y2, int partitions) {
        if(x1 >= x2 || y1 > y2 || partitions < 0)
            throw new IllegalArgumentException("Illegal arguments of City.");
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = y1;
        this.x4 = y2;
        this.partitions = partitions;
        xRangePartition = new RangePartition(partitions, x1, x2);
        yRangePartition = new RangePartition(partitions, y1, y2);
        zOrderCoding = new ZOrderCoding(partitions);
    }

    public int getZCodeForALocation(double x, double y) {
        return zOrderCoding.getZCode(xRangePartition.getPartition(x), yRangePartition.getPartition(y));
    }

    public Intervals getZCodeIntervalsUnderARectagle(double x1, double x2, double y1, double y2) {
        if(x1 > x2 || y1 > y2)
            throw new IllegalArgumentException("Illegal argument for a rectangle.");
        final int xPartition1 = xRangePartition.getPartition(x1);
        final int xPartition2 = xRangePartition.getPartition(x2);
        final int yPartition1 = yRangePartition.getPartition(y1);
        final int yPartition2 = yRangePartition.getPartition(y2);
        return zOrderCoding.getIntervalsOfCodesInRectangle(xPartition1, xPartition2, yPartition1, yPartition2);
    }


}
