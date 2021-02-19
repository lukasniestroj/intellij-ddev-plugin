package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.diff.util.DiffGutterOperation;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyRunConfiguration extends RunConfigurationBase<MyRunConfigurationsOptions> {

    protected MyRunConfiguration(@NotNull Project project, @Nullable ConfigurationFactory factory, @Nullable String name) {
        super(project, factory, name);
    }

    @Override
    protected @NotNull MyRunConfigurationsOptions getOptions() {
        return (MyRunConfigurationsOptions) super.getOptions();
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new MySettingsEditor();
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        super.checkConfiguration();
        if (StringUtil.isEmptyOrSpaces(getOptions().getCommand())) {
            throw new RuntimeConfigurationError(
                    "Command can not be empty!",
                    () -> getOptions().setCommand("start")
            );
        }
    }

    @Override
    public @Nullable RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
        return new CommandLineState(environment) {
            @Override
            protected @NotNull ProcessHandler startProcess() throws ExecutionException {
                List<String> commands = new ArrayList<>();
                commands.add("ddev");
                commands.add(getOptions().getCommand());
                GeneralCommandLine commandLine = new GeneralCommandLine(commands);

                String dir = getOptions().getWorkingDirectory();

                if (StringUtil.isEmptyOrSpaces(dir)) {
                    dir = getProject().getBasePath();
                }
                commandLine.setWorkDirectory(dir);

                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }
}
