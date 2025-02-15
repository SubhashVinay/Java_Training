package com.st.burger;

public class Store {

    public static void main(String[] args) {

        Meal meal=new Meal();
        System.out.println(meal);

        Meal usRegularMeal=new Meal(0.68);
        System.out.println(usRegularMeal);
    }
}
