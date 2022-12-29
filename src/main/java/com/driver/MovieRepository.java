package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDB=new HashMap<>();
    HashMap<String,Director> directorDB=new HashMap<>();
    HashMap<Director,List<Movie>> assignedDB=new HashMap<>();
    public String addDirector(Director director) {
         directorDB.put(director.getName(),director);
         return "success";
    }
    public void deleteAllDirectors() {
        assignedDB.clear();
    }

    public void deleteDirectorByName(String name) {
        if(directorDB.containsKey(name)){
            directorDB.remove(name);
        }
        for(Director d:assignedDB.keySet()){
            if(d.getName()==name){
                assignedDB.remove(d);
            }
        }
    }

    public List<Movie> findAllMovies() {
        List<Movie> movieList=new ArrayList<>();
        for(Movie m:movieDB.values()){
            movieList.add(m);
        }
        for(List<Movie> m:assignedDB.values()){
            movieList.addAll(m);
        }
        return movieList;
    }

    public Director getDirectorByName(String name) {
        Director ans=null;
        if(directorDB.containsKey(name)){
            return directorDB.get(name);
        }
        for(Director d:assignedDB.keySet()){
            if(d.getName()==name){
                return d;
            }
        }
        return ans;
    }

    public Movie getMovieByName(String name) {
         String key=name;
         if(movieDB.containsKey(key)){
             return movieDB.get(name);
         }
         for(List<Movie> x:assignedDB.values()){
             for(Movie m:x){
                 if(m.getName()==name){
                     return m;
                 }
             }
         }
         return null;
    }

    public String addMovieDirectorPair(String movieName,String directorName){
       if(directorDB.containsKey(directorName)){
           List<Movie> movieList=new ArrayList<>();
           movieList.add(movieDB.remove(movieName));//added in movielist

           assignedDB.put(directorDB.remove(directorName),movieList);
           return "success";
       }
       for(Director d:assignedDB.keySet()){
           if(d.getName()==directorName){
               List<Movie> temp=assignedDB.get(d);
               temp.add(movieDB.remove(movieName));
               assignedDB.put(d,temp);
           }
       }
       return "success";
    }

    public String addMovie(Movie movie) {
        movieDB.put(movie.getName(),movie);
        return "success";
    }

    public List<Movie> getMoviesByDirectorName(String name) {
        Director ans=null;
        for(Director d:assignedDB.keySet()){
            if(d.getName()==name){
                ans=d;
            }
        }
        if(ans==null){
            return null;
        }
        return assignedDB.get(ans);
    }
}
