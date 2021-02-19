package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

import javax.annotation.Nullable;

public class MyRunConfigurationsOptions extends RunConfigurationOptions {

    private final StoredProperty<String> myCommand = string("").provideDelegate(this, "command");
    private final StoredProperty<String> myWorkingDirectory = string("").provideDelegate(this, "workingDirectory");

    public @Nullable String getCommand() {
        return myCommand.getValue(this);
    }

    public void setCommand(String command) {
        myCommand.setValue(this, command);
    }

    public @Nullable String getWorkingDirectory() {
        return myWorkingDirectory.getValue(this);
    }

    public void setWorkingDirectory(String workingDirectory) {
        myWorkingDirectory.setValue(this, workingDirectory);
    }
}
