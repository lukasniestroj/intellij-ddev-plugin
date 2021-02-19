package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MyRunConfigurationType implements ConfigurationType {
    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "ddev";
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) String getConfigurationTypeDescription() {
        return "ddev run configuration type";
    }

    @Override
    public Icon getIcon() {
        return MyPluginIcons.FileType;
    }

    @Override
    public @NotNull String getId() {
        return "DDEV_RUN_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new MyRunConfigurationFactory[]{new MyRunConfigurationFactory(this)};
    }
}
