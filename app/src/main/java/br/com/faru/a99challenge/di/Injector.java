package br.com.faru.a99challenge.di;

import br.com.faru.a99challenge.di.component.ChallengeComponent;

public class Injector {

    private static Injector instance = new Injector();
    private static ChallengeComponent component;

    public static Injector getInstance() {
        return instance;
    }

    private Injector() {
    }

    public static void initialize(ChallengeComponent gotComponent) {
        component = gotComponent;
    }

    public static ChallengeComponent getComponent() {
        if (component != null) {
            return component;
        } else {
            throw new IllegalArgumentException("Impossible to get the component instance. This class must be initialized before");
        }
    }
}
