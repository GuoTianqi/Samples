package com.gtq.javasample.stringsimilarity;

import info.debatty.java.stringsimilarity.Cosine;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "张学友-如果那都不算爱(Live)";
        String s2 = "如果那都不算爱-张学友";

        // Let's work with sequences of 2 characters...
        Cosine cosine = new Cosine(2);

        // Pre-compute the profile of strings
        Map<String, Integer> profile1 = cosine.getProfile(s1);
        Map<String, Integer> profile2 = cosine.getProfile(s2);

        // Prints 0.516185
        System.out.println(cosine.similarity(profile1, profile2));
    }
}
