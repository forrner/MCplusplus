package com.forrner.mcpp.util;

import net.minecraft.util.StringRepresentable;

public enum TripleBlockPart implements StringRepresentable {
    LOWER("lower"),
    MIDDLE("middle"),
    UPPER("upper");

    private final String name;

    TripleBlockPart(final String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}