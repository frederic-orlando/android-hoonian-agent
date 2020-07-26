package com.example.hoonianAgent.model.content.property;

import com.example.hoonianAgent.model.content.base.BaseSerializableObject;
import com.example.hoonianAgent.model.content.customShape.Point;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Unit extends BaseSerializableObject {
    private String id;
    private String name;
    private String coordinate;
    @SerializedName("project_block")
    private Block block;
    @SerializedName("project_unit_status")
    private Status status;
    @SerializedName("project_unit_types")
    private UnitType type;
    @SerializedName("total_unit")
    private int total;
    @SerializedName("available_unit")
    private int availableUnit;

    public ArrayList<Point> getCoordinate() {
        ArrayList<Point> points = new ArrayList<>();
        String[] coordinates = coordinate.split("\\|");
        for (String point: coordinates) {
            String[] xy = point.split("\\.");
            points.add(new Point(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }

        return points;
    }

    // Todo: remove, dummy constructor
    public Unit(String coordinate, String color) {
        this.coordinate = coordinate;
        this.status = new Status(color);
    }
}
