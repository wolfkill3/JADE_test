package com.company;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        profile.setParameter(Profile.GUI, "true");
        profile.setParameter(Profile.LOCAL_PORT,"1101");
        ContainerController controller = runtime.createMainContainer(profile);
        AgentController firstAgentController, secondAgentController;

        try {
            firstAgentController = controller.createNewAgent("First_Agent", FirstAgent.class.getName(), null);
            secondAgentController = controller.createNewAgent("Second_Agent", SecondAgent.class.getName(), null);

            firstAgentController.start();
            secondAgentController.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
