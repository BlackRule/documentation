@Inject
private Notifications notifications;
@Inject
private UiComponents uiComponents;

@Subscribe
protected void onInit(InitEvent event) {
    Timer helloTimer = uiComponents.create(Timer.NAME);
    getWindow().addTimer(helloTimer); <1>
    helloTimer.setId("helloTimer"); <2>
    helloTimer.setDelay(5000);
    helloTimer.setRepeating(true);

    helloTimer.addTimerActionListener(e -> { <3>
        notifications.create()
                .withCaption("Hello")
                .show();
    });

    helloTimer.addTimerStopListener(e -> { <4>
        notifications.create()
                .withCaption("Timer is stopped")
                .show();
    });

    helloTimer.start(); <5>
}