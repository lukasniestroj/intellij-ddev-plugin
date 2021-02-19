package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MySettingsEditor extends SettingsEditor<MyRunConfiguration> {

    private JPanel myPanel;
    private LabeledComponent<EditorTextField> myCommand;
    private LabeledComponent<TextFieldWithBrowseButton> myWorkingDirectory;

    @Override
    protected void resetEditorFrom(@NotNull MyRunConfiguration s) {
        myCommand.getComponent().setText(s.getOptions().getCommand());
        myWorkingDirectory.getComponent().setText(s.getOptions().getWorkingDirectory());
    }

    @Override
    protected void applyEditorTo(@NotNull MyRunConfiguration s) throws ConfigurationException {
        s.getOptions().setCommand(myCommand.getComponent().getText());
        s.getOptions().setWorkingDirectory(myWorkingDirectory.getComponent().getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return myPanel;
    }

    private void createUIComponents() throws ConfigurationException {
        myCommand = new LabeledComponent<>();
        myCommand.setComponent(new EditorTextField());

        myWorkingDirectory = new LabeledComponent<>();
        TextFieldWithBrowseButton textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        textFieldWithBrowseButton.addBrowseFolderListener(
                "Choose a working directory",
                "",
                null,
                FileChooserDescriptorFactory.createSingleFolderDescriptor()
        );
        myWorkingDirectory.setComponent(textFieldWithBrowseButton);
    }
}
