package com.reckontech.cicnp.cicnp.Watch;

/**
 * Created by Dell on 9/3/2016.
 */
public class WatchRecyclerDataWrapper {

    public String name;
    public String phone;
    public String citizenshipNumber;
    public String image;

    public WatchRecyclerDataWrapper(String name, String phone, String citizenshipNumber)
    {
        this.name = name;
        this.phone = phone;
        this.citizenshipNumber = citizenshipNumber;
    }

    public WatchRecyclerDataWrapper(String name, String phone, String citizenshipNumber, String image)
    {
        this.name = name;
        this.phone = phone;
        this.citizenshipNumber = citizenshipNumber;
        this.image = image;
    }
}
