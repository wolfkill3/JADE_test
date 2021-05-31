package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class FirstAgent extends Agent {

    @Override
    protected void setup(){
        System.out.println("I'm first agent");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.setContent("Handshake! ");
                message.addReceiver(new AID("Second_Agent", AID.ISLOCALNAME));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                send(message);
            }
        });
    }
}
