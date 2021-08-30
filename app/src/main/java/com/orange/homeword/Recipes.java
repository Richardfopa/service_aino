package com.orange.homeword;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Recipes implements Parcelable {

    private String name;
    private String description;
    private int srccompat;
    private String ingredient;
    private String preparation;

    @Override
    public String toString() {
        return "Recipes{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", srccompat=" + srccompat +
                ", ingredient='" + ingredient + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }

    public int getSrccompat() {
        return srccompat;
    }

    public void setSrccompat(int srccompat) {
        this.srccompat = srccompat;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public Recipes(String name, String description, int srccompat, String ingredient, String preparation) {
        this.name = name;
        this.description = description;
        this.srccompat = srccompat;
        this.ingredient = ingredient;
        this.preparation = preparation;
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

    protected Recipes(Parcel in) {
        name = in.readString();
        description = in.readString();
        srccompat = in.readInt();
        ingredient = in.readString();
        preparation = in.readString();
    }

    public static final Creator<Recipes> CREATOR = new Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(srccompat);
        parcel.writeString(ingredient);
        parcel.writeString(preparation);

    }
}
