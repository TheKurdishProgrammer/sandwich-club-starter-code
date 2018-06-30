package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;

        try {

            JSONObject sandwichRoot = new JSONObject(json);
            JSONObject name = sandwichRoot.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnowAsJSonArray = name.getJSONArray("alsoKnownAs");

            List<String> alsoKnowAs = new ArrayList<>();


            for (int i = 0; i < alsoKnowAsJSonArray.length(); i++) {
                alsoKnowAs.add(alsoKnowAsJSonArray.getString(i));
            }


            String placeOfOrigin = sandwichRoot.getString("placeOfOrigin");

            String describtion = sandwichRoot.getString("description");

            String imageURL = sandwichRoot.getString("image");

            JSONArray ingredentJSONArray = sandwichRoot.getJSONArray("ingredients");

            List<String> ingridents = new ArrayList<>();


            for (int i = 0; i < ingredentJSONArray.length(); i++) {
                ingridents.add(ingredentJSONArray.getString(i));
            }

            sandwich = new Sandwich();
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnowAs);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(describtion);
            sandwich.setImage(imageURL);
            sandwich.setIngredients(ingridents);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }

}
