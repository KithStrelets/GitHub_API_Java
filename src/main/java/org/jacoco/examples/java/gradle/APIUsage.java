
package org.jacoco.examples.java.gradle;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



/**
 *
 * @author Никита
 * 2017-09-01
 */
public class APIUsage {
    private final String TOKEN = "350f86c02aaae9830fd2c185006b3c11ff00e9ec";
    private URI uri;
    private final Converter CONVERTER = new Converter();
     
      public ArrayList<Repository> getMostStarredReps(){
        try {
            uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("api.github.com")
                    .setPath("/search/repositories")
                    .setParameter("q", "stars:>=10000")
                    .setParameter("sort", "stars")
                    .setParameter("order", "desc").build();
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(uri);
            httpget.setHeader("Authorization", "token " + TOKEN);
            httpget.setHeader("Accept", "application/vnd.github.nightshade-preview+json");
            
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            ArrayList<Repository> res = CONVERTER.repositoryDeserialize(EntityUtils.toString(entity));            
            return res;
        }
        catch (URISyntaxException | IOException | ParseException ex) {ex.printStackTrace();}
        return null;
      }
      public ArrayList<Repository> getTenMostCommited(ArrayList<Repository> mostStarred, String sinceYYYYMMDD, String untilYYYYMMDD){
          try {
            CloseableHttpClient httpclient;
            HttpGet httpget;
            CloseableHttpResponse response;
            HttpEntity entity;         
            int page = 1;
            String responseString;
            for(Repository rep:mostStarred){
                HashMap<String, Integer> commits = new HashMap<>();
                while(true){
                    HashMap<String, Integer> tempMap = commits;
                    uri = new URIBuilder()
                            .setScheme("https")
                            .setHost("api.github.com")
                            .setPath("/repos/"+ rep.getName() +"/commits")
                            .setParameter("since", sinceYYYYMMDD)
                            .setParameter("until", untilYYYYMMDD)
                            .setParameter("page", String.valueOf(page))
                            .setParameter("per_page", "60").build();
                    httpclient = HttpClients.createDefault();
                    httpget = new HttpGet(uri);
                    httpget.setHeader("Authorization", "token " + TOKEN);
                    httpget.setHeader("Accept", "application/vnd.github.cloak-preview");

                    response = httpclient.execute(httpget);
                    entity = response.getEntity();
                    responseString = EntityUtils.toString(entity);
                    if(responseString.equals("[]"))break;
                    commits = (HashMap<String, Integer>)CONVERTER.commitsDeserialize(responseString, tempMap);
                    page++;
                }
                int count = 0;
                for(int i : commits.values()){
                    count+=i;
                }
                rep.setCommitsNum(count);
                rep.setTopContributors(CONVERTER.getTopContributors(commits));
                page = 1;
        }
            mostStarred.sort(Comparator.comparing((repository) -> repository.getCommitsNum()));
        }
        catch (URISyntaxException | IOException ex) {ex.printStackTrace();}
        ArrayList<Repository> res = new ArrayList<>();
        for(int i = mostStarred.size() - 1; i >= mostStarred.size() - 10; i--){
            res.add(mostStarred.get(i));
        }
        System.out.println(res.toString());
        return res;
      }
}

        
    
     

