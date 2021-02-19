package com.github.lukasniestroj.intellijddevtools.runConfiguration;

import com.intellij.ui.IconManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MyPluginIcons {
    private static @NotNull Icon load(@NotNull String path) {
        return IconManager.getInstance().getIcon(path, MyPluginIcons.class);
    }

    public static final @NotNull Icon FileType = load("/icons/logo.svg");
    public static final @NotNull Icon Logo = load("/icons/ddev-logo.svg");
    public static final @NotNull Icon LogoWithBg = load("/icons/ddev-logo-with-bg.svg");
}
