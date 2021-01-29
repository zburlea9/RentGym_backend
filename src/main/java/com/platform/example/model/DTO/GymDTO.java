package com.platform.example.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GymDTO {

    private Long id;
    private String name;
    private String description;
    private String location;
    private Float price;
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public GymDTO() {
    }

    public GymDTO(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("description") String description,
                  @JsonProperty("location") String Location,
                  @JsonProperty("price") Float price,
                  @JsonProperty("type") String type) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.location = Location;
        this.price = price;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GymDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
