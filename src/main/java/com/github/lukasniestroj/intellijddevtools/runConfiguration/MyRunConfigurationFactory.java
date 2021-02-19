package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyRunConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "ddev configuration factory";

    protected MyRunConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new MyRunConfiguration(project, this, "ddev");
    }

    @NotNull
    @Override
    public String getName() {
        return FACTORY_NAME;
    }

    @Nullable
    @Override
    public Class<? extends BaseState> getOptionsClass() {
        return MyRunConfigurationsOptions.class;
    }

}
