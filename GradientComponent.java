package ru.xw1w1.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.jetbrains.annotations.NotNull;

public class GradientComponent implements ComponentLike {

    private String content;
    private String hexFirst;
    private String hexSecond;

    public GradientComponent of(
            @NotNull String content, @NotNull TextColor first, @NotNull TextColor second
    ) {
        this.content = content;
        this.hexFirst = first.asHexString();
        this.hexSecond = second.asHexString();
        return new GradientComponent();
    }

    /**
     * Gets a {@link Component} representation.
     *
     * @return a component
     * @since 4.0.0
     */
    @Override
    public @NotNull Component asComponent() {
        return MiniMessage.miniMessage().deserialize("<gradient:<hex1>:<hex2>><content>",
                Placeholder.unparsed("hex1", hexFirst), Placeholder.unparsed("hex2", hexSecond),
                Placeholder.unparsed("content", content)
        );
    }

}
