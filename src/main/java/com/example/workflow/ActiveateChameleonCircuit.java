package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.Bpmn;

import javax.inject.Named;
import java.util.Random;

@Named
public class ActiveateChameleonCircuit implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String doctor = (String)delegateExecution.getVariable("doctor");
        System.out.println("The Chameleon Circuit has been broken since 1963 "+ doctor);


        throw new BpmnError("ChameleonCircuitBroken");

    }
}
