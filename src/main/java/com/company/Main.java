package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        RouteParser parser = new RouteParser();
        parser.addRouteWithParams("/users/{}/posts/{}", "/users/(\\d+)/posts/(\\d+)", Arrays.asList("userId", "postId"));
        parser.addRouteWithParams("/books/{}/chapters/{}", "/books/(\\d+)/chapters/(\\d+)", Arrays.asList("bookId", "chapterId"));

        String url = "/users/123/posts/456";
        List<String> paramNames = Arrays.asList("userId", "postId");
        Map<String, String> params = parser.parseWithParams(url, paramNames);
        if (params != null) {
            System.out.println("Parsed parameters:");
            params.forEach((key, value) -> System.out.println(key + ": " + value));
        } else {
            System.out.println("No matching route found for " + url);
        }
    }
}
