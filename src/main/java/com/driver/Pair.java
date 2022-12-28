package com.driver;

class Pair{
    private String movieName;
    private String directorName;
    public Pair(String movieName, String directorName){
        this.directorName=directorName;
        this.movieName=movieName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getMovieName() {
        return movieName;
    }
}
