package com.myProject.project.product.enums;

import java.util.List;

public enum Category {

    Bar_Bending_Machine("Bar Bending Machine"),
    Bar_Cutting_Machine("Bar Cutting Machine"),
    Rebar_Cutting_Machine("Rebar Cutting Machine"),
    Tmt_Bar_Bending_Machine("Tmt Bar Bending Machine"),
    Tmt_Bar_Cutting_Machine("Tmt Bar Cutting Machine"),
    Automatic_Ring_Making_Machine("Automatic Ring Making Machine");



    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static List<Category> getAllProductCategories() {
        return List.of(Category.values());
    }

    }



