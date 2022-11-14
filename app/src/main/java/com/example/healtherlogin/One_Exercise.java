package com.example.healtherlogin;

class One_Exercise {
    public String Exercise;
    public String Weight;
    public String Repetition;
    public String Setcount;

    public String getexercise() {
        return Exercise;
    }

    public String getweight() {
        return Weight;
    }

    public String getrepetition(){
        return Repetition;
    }

    public String getset_count(){
        return Setcount;
    }


    public void setexercise(String Exercise){
        this.Exercise=Exercise;
    };

    public void setweight(String Weight){
        this.Weight=Weight;
    };

    public void setrepetition(String Repetition){
        this.Repetition=Repetition;
    };

    public void setsetcount(String Setcount){
        this.Setcount=Setcount;
    };



    public One_Exercise(){

    }

    public One_Exercise(String Exercise, String Weight, String Repetition, String Setcount){
        this.Exercise=Exercise;
        this.Weight=Weight;
        this.Repetition=Repetition;
        this.Setcount=Setcount;
    }
}
