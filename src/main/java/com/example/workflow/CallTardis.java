package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class CallTardis implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String doctor = (String) delegateExecution.getVariableLocal("doctor");

        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("NEED_TARDIS")
                .setVariable("BusKey", delegateExecution.getBusinessKey())
                .setVariable("doctor", doctor)
                .correlate();

    }
}
