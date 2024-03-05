package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RouteParser {
    private final Map<String, Pattern> routePatterns;

    public RouteParser() {
        routePatterns = new HashMap<>();
    }

    public void addRoute(String route, String pattern) {
        routePatterns.put(route, Pattern.compile(pattern));
    }

    public void addRouteWithParams(String route, String pattern, List<String> paramNames) {
        String updatedPattern = pattern;
        for (String paramName : paramNames) {
            updatedPattern = updatedPattern.replaceFirst("\\{\\}", "(\\\\w+)");
        }
        routePatterns.put(route, Pattern.compile(updatedPattern));
    }

    public Map<String, String> parseWithParams(String url, List<String> paramNames) {
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, Pattern> entry : routePatterns.entrySet()) {
            Matcher matcher = entry.getValue().matcher(url);
            if (matcher.matches()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    params.put(paramNames.get(i - 1), matcher.group(i));
                }
                return params;
            }
        }
        return null;
    }

    public Map<String, String> parse(String url) {
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, Pattern> entry : routePatterns.entrySet()) {
            Matcher matcher = entry.getValue().matcher(url);
            if (matcher.matches()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    params.put("param" + i, matcher.group(i));
                }
                return params;
            }
        }
        return null;
    }
    public boolean hasRoute(String route) {
        return routePatterns.containsKey(route);
    }

    public boolean hasPattern(String pattern) {
        return routePatterns.containsValue(Pattern.compile(pattern));
    }

    public void removeRoute(String route) {
        routePatterns.remove(route);
    }

    public void removeAllRoutes() {
        routePatterns.clear();
    }
    public List<String> getAllRoutes() {
        return new ArrayList<>(routePatterns.keySet());
    }

    public List<String> getAllPatterns() {
        return routePatterns.values().stream()
                .map(Pattern::pattern)
                .collect(Collectors.toList());
    }

    public boolean hasMatchingRoute(String url) {
        for (Pattern pattern : routePatterns.values()) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMatchingPattern(String url) {
        for (Pattern pattern : routePatterns.values()) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    public void printAllRoutes() {
        for (String route : routePatterns.keySet()) {
            System.out.println(route);
        }
    }

    public void printAllPatterns() {
        for (Pattern pattern : routePatterns.values()) {
            System.out.println(pattern.pattern());
        }
    }
}
