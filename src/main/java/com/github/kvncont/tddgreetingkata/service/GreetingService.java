package com.github.kvncont.tddgreetingkata.service;

import java.util.ArrayList;
import java.util.List;

public class GreetingService {
    public static final String HELLO = "Hello, ";

    public String greeting(List<String> name) {
        List<String> listUppercaseNames = new ArrayList<>();
        if (name == null) {
            return "Hello, my friend.";
        } else {
            splitNames(name);
            splitUppercaseNames(name, listUppercaseNames);
            if (name.size() == 2) {
                return checkTwoNames(name, listUppercaseNames);
            }
            if (name.size() > 2) {
                return checkMoreThanTwoNames(name);
            }
        }
        return (listUppercaseNames.isEmpty()) ? HELLO + name.get(0) + "." : "HELLO " + listUppercaseNames.get(0) + "!";
    }

    private void splitNames(List<String> name) {
        String[] splitName;
        for (var i = name.size() - 1; i >= 0; i--) {
            if (name.get(i).contains(",")) {
                splitName = name.get(i).split(",");
                name.remove(i);
                for (var j : splitName) {
                    name.add(j.trim());
                }
            }
        }
    }

    private void splitUppercaseNames(List<String> name, List<String> listUppercaseNames) {
        for (var i = name.size() - 1; i >= 0; i--) {
            if (name.get(i).equals(name.get(i).toUpperCase())) {
                listUppercaseNames.add(name.get(i));
                name.remove(i);
            }
        }
    }

    private String checkMoreThanTwoNames(List<String> name) {
        var message = new StringBuilder(HELLO);
        for (var i = 0; i < name.size(); i++) {
            if (!name.get(i).equals(name.get(i).toUpperCase())) {
                message.append(name.get(i));
                if (i != (name.size() - 1)) {
                    message.append(", ");
                }
                if (i == (name.size() - 2)) {
                    message.append("and ");
                }
            }
        }
        return message + ".";
    }

    private String checkTwoNames(List<String> name,List<String> listUppercaseNames) {
        var message = new StringBuilder(HELLO);
        for (var i = 0; i < name.size(); i++) {
            message.append(name.get(i));
            if (i != (name.size() - 1)) {
                message.append(" and ");
            }
        }
        return (listUppercaseNames.isEmpty()) ? message + "." : message + "." + " AND HELLO " + listUppercaseNames.get(0) + "!";
    }
}
