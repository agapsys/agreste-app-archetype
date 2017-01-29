package com.example;

import com.agapsys.agreste.test.ColoredConsoleLogStream;
import com.agapsys.web.toolkit.modules.LogModule;

public class TestApplication extends Application {

    @Override
    protected boolean isAbuseCheckEnabled() {
        return false; // <-- Required for tests
    }

    @Override
    protected void beforeAgresteStart() {
        super.beforeAgresteStart();

        LogModule logModule = getModule(LogModule.class);
        logModule.addStream(new ColoredConsoleLogStream());
    }

}
