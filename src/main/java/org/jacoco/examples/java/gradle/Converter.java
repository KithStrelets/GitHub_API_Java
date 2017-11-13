package org.jacoco.examples.java.gradle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Converter {
    
    public ArrayList<Repository> repositoryDeserialize(String targetJsonString){
        
        if(targetJsonString.length() == 0)return null;
             JSONObject jsonObj = new JSONObject(targetJsonString);
             Repository result;
             ArrayList<Repository> repsList = new ArrayList<>();
             JSONArray items = jsonObj.getJSONArray("items");
             for(int i = 0; i < items.length(); i++){
                 result = new Repository();
                 result.setName(items.getJSONObject(i).getString("full_name"));
                 result.setUrl(items.getJSONObject(i).getString("html_url"));
                 result.setDescription((items.getJSONObject(i).isNull("description")) ? "" : items.getJSONObject(i).getString("description"));
                 result.setLanguage((items.getJSONObject(i).isNull("language")) ? "" : items.getJSONObject(i).getString("language"));
                 result.setStars(items.getJSONObject(i).getInt("stargazers_count"));
                 repsList.add(result);
             }
             return repsList;
    } 

    public HashMap<String, Integer> commitsDeserialize(String targetJsonString, HashMap<String, Integer> targetMap){
            if(targetJsonString.length() == 0)return null;
            HashMap<String, Integer> result = (targetMap.isEmpty()) ? new HashMap<>() : targetMap;
             JSONArray items = new JSONArray(targetJsonString);
             String key;
             int value;
             for(int i = 0; i < items.length(); i++){
                 key = (items.getJSONObject(i).isNull("committer")) ? "" : items.getJSONObject(i).getJSONObject("committer").getString("login");
                 if(result.containsKey(key)){
                    value = result.get(key);
                    result.replace(key,value+1);  
                 }else{
                     result.put(key, 1);
                 }
             }        
            return result;            
    }
    
    public ArrayList<Contributor> getTopContributors(HashMap<String,Integer> contributors){
        ArrayList<Contributor> temp = new ArrayList<>();
        ArrayList<Contributor> res = new ArrayList<>();
        HashMap<String,Integer> instance = contributors;
        instance.keySet().forEach((obj) -> {
            temp.add(new Contributor(obj, instance.get(obj)));
        });
        temp.sort(Comparator.comparing((repository) -> repository.getCommitNum()));
        for(int i = temp.size() - 1; i > temp.size() - 6 & i >= 0; i--){
            res.add(temp.get(i));
        }
        return res;
    }
}



