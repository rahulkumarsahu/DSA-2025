package com.dsa2025.learn.lld.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

// child have all access to parent
public class MBAStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Micro Economics");
        subs.add("Business Studies");
        subs.add("Operations Management");
        this.subjects = subs;
        return this;
    }
}
