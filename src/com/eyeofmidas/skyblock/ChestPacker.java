package com.eyeofmidas.skyblock;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class ChestPacker {
	public static void addItem(Chest chest, Material material, int amount) {
		ItemStack item = new ItemStack(material, amount);
		chest.getBlockInventory().addItem(item);
	}
	
	public static void addItem(Chest chest, Material material, int amount, int data) {
		ItemStack item = new ItemStack(material, amount, (short)data);
		chest.getBlockInventory().addItem(item);
	}
}
