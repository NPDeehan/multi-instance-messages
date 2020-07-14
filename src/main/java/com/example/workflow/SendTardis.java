package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class SendTardis implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String BusKey = (String) delegateExecution.getVariable("BusKey");
        String doctor = (String) delegateExecution.getVariable("doctor");

        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("TARDIS")
                .processInstanceBusinessKey(BusKey)
                .localVariableEquals("doctor", doctor)
                .correlate();

        System.out.println("Tardis is on it's way to "+ doctor);




    }
}
