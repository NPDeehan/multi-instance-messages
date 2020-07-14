package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Random;

@Named
public class ActivateTimeCircuits implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Random timeLord = new Random();
        int waitTime = timeLord.nextInt(30) + 5;

        delegateExecution.setVariable("timeyWimey", "PT"+waitTime+"S");
    }

}
