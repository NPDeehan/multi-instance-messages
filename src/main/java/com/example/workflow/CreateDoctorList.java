package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Named
public class CreateDoctorList implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        List<String> doctors = new ArrayList<String>();

        doctors.add("Tennant");
        doctors.add("Jodie");
        doctors.add("Capaldi");
        doctors.add("Smith");

        delegateExecution.setVariable("doctors", doctors);

    }
}
