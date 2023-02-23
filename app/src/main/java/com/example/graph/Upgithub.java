package com.example.graph;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Upgithub {



    //@GET("/Information_b2.php")
    //@GET("/Information_b2test.php")
    @GET("/uptrade.php")
    Call<List<Upitem>> contributors(@Query("name") String name,
                                    @Query("pyeungsu") String pyeungsu,
                                    @Query("area") String area,
                                    @Query("jiyeokcode") String jiyeokcode,
                                    @Query("jibun") String jibun);
}