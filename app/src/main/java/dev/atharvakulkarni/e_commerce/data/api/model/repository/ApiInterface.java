package dev.atharvakulkarni.e_commerce.data.api.model.repository;


import retrofit2.http.GET;
import retrofit2.http.Path;

interface ApiInterface
{
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}