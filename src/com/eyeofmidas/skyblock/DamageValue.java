package com.eyeofmidas.skyblock;

public enum DamageValue {
	OAK_SAPLING((short) 1), SPRUCE_SAPLING((short) 2);

	private final short id;

	private DamageValue(final short id) {
		this.id = id;
	}

	public short getId() {
		return this.id;
	}
}
