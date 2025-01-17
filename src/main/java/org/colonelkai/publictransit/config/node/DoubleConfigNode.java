package org.colonelkai.publictransit.config.node;

import org.core.config.ConfigurationNode;
import org.core.config.ConfigurationStream;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DoubleConfigNode extends AbstractConfigNode<Double> {

    public DoubleConfigNode(ConfigurationNode path, double defaultValue) {
        super(path, defaultValue);
    }

    @Override
    protected @NotNull Optional<Double> get(@NotNull ConfigurationStream stream) {
        return stream.getDouble(this.getPath());
    }

    @Override
    protected void set(@NotNull ConfigurationStream stream, @NotNull Double value) {
        stream.set(this.getPath(), value);
    }
}
