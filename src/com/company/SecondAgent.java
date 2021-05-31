package com.company;

import javax.swing.*;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SecondAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("I'm second agent");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    JOptionPane.showMessageDialog(null, "Received message from" + message.getSender().getLocalName() + " :" + message.getContent());
                } else {
                    block();
                }
            }
        });
    }
}
