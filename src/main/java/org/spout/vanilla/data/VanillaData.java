/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.data;

import org.spout.api.inventory.Inventory;
import org.spout.api.inventory.ItemStack;
import org.spout.api.map.DefaultedKey;
import org.spout.api.map.DefaultedKeyImpl;
import org.spout.api.material.Material;
import org.spout.api.math.Vector3;

import org.spout.vanilla.material.VanillaMaterials;

/**
 * * Common Vanilla-like data mappings that are found in Vanilla.
 */
public class VanillaData {
	//World-specific
	public static final DefaultedKey<Dimension> DIMENSION = new DefaultedKeyImpl<Dimension>("dimension", Dimension.NORMAL);
	public static final DefaultedKey<Difficulty> DIFFICULTY = new DefaultedKeyImpl<Difficulty>("difficulty", Difficulty.EASY);
	public static final DefaultedKey<Weather> WEATHER = new DefaultedKeyImpl<Weather>("weather", Weather.CLEAR);
	public static final DefaultedKey<WorldType> WORLD_TYPE = new DefaultedKeyImpl<WorldType>("world_type", WorldType.DEFAULT);
	//Component-specific
	public static final DefaultedKey<GameMode> GAMEMODE = new DefaultedKeyImpl<GameMode>("game_mode", GameMode.SURVIVAL);
	public static final DefaultedKey<Integer> AIR_TICKS = new DefaultedKeyImpl<Integer>("air_ticks", 0);
	public static final DefaultedKey<Integer> DEATH_TICKS = new DefaultedKeyImpl<Integer>("death_ticks", 0);
	public static final DefaultedKey<Integer> FIRE_TICKS = new DefaultedKeyImpl<Integer>("fire_ticks", 0);
	public static final DefaultedKey<Long> GROWTH_TICKS = new DefaultedKeyImpl<Long>("growth_ticks", Long.valueOf(0));
	public static final DefaultedKey<Boolean> FLAMMABLE = new DefaultedKeyImpl<Boolean>("flammable", false);
	public static final DefaultedKey<Integer> HEALTH = new DefaultedKeyImpl<Integer>("health", 1);
	public static final DefaultedKey<Integer> MAX_HEALTH = new DefaultedKeyImpl<Integer>("max_health", 1);
	public static final DefaultedKey<Vector3> MAX_SPEED = new DefaultedKeyImpl<Vector3>("max_speed", Vector3.ZERO);
	public static final DefaultedKey<Vector3> MOVEMENT_SPEED = new DefaultedKeyImpl<Vector3>("movement_speed", Vector3.ZERO);
	public static final DefaultedKey<Integer> INTERACT_REACH = new DefaultedKeyImpl<Integer>("interact_reach", 5);
	public static final DefaultedKey<Vector3> VELOCITY = new DefaultedKeyImpl<Vector3>("velocity", Vector3.ZERO);
	public static final DefaultedKey<ItemStack[]> ITEMS = new DefaultedKeyImpl<ItemStack[]>("items", new ItemStack[36]);
	//Entity data
	public static final DefaultedKey<Boolean> IS_FALLING = new DefaultedKeyImpl<Boolean>("is_falling", false);
	public static final DefaultedKey<Boolean> IS_ON_GROUND = new DefaultedKeyImpl<Boolean>("is_on_Ground", true);
	public static final DefaultedKey<Boolean> IS_JUMPING = new DefaultedKeyImpl<Boolean>("is_jumping", false);
	public static final DefaultedKey<Boolean> HAS_DEATH_ANIMATION = new DefaultedKeyImpl<Boolean>("has_death_animation", true);
	//Human-specific
	public static final DefaultedKey<Boolean> IS_SPRINTING = new DefaultedKeyImpl<Boolean>("is_sprinting", false);
	public static final DefaultedKey<Boolean> IS_FLYING = new DefaultedKeyImpl<Boolean>("is_flying", false);
	public static final DefaultedKey<Inventory> INVENTORY = new DefaultedKeyImpl<Inventory>("inventory", new Inventory());
	//Creature-specific
	public static final DefaultedKey<Integer> LINE_OF_SIGHT = new DefaultedKeyImpl<Integer>("line_of_sight", 1);
	//Item-specific
	public static final DefaultedKey<Integer> UNCOLLECTABLE_TICKS = new DefaultedKeyImpl<Integer>("uncollectable_ticks", 10);
	//Head-specific
	public static final DefaultedKey<Integer> HEAD_HEIGHT = new DefaultedKeyImpl<Integer>("head_height", 1);
	public static final DefaultedKey<Integer> HEAD_YAW = new DefaultedKeyImpl<Integer>("head_yaw", 0);
	//MovingMaterial-specific
	public static final DefaultedKey<String> MATERIAL_NAME = new DefaultedKeyImpl<String>("material_name", VanillaMaterials.AIR.getName());
	//XPOrb-specific
	public static final DefaultedKey<Short> EXPERIENCE_AMOUNT = new DefaultedKeyImpl<Short>("experience_amount", (short) 0);
	public static final DefaultedKey<Long> TIME_DISPERSED = new DefaultedKeyImpl<Long>("time_dispersed", Long.valueOf(0));
	//Slime-specific
	public static final DefaultedKey<Byte> SLIME_SIZE = new SlimeSize("slime_size");
	//Sheep-specific
	public static final DefaultedKey<Short> WOOL_COLOR = new DefaultedKeyImpl<Short>("wool_color", (short) 0);
	public static final DefaultedKey<Boolean> SHEARED = new DefaultedKeyImpl<Boolean>("sheared", false);
	//Pig-specific
	public static final DefaultedKey<Boolean> SADDLED = new DefaultedKeyImpl<Boolean>("saddled", false);
	//Wolf/Ocelot-specific
	public static final DefaultedKey<Boolean> SITTING = new DefaultedKeyImpl<Boolean>("is_sitting", false);
	public static final DefaultedKey<Boolean> TAMED = new DefaultedKeyImpl<Boolean>("is_tamed", false);
	//Ocelot-specific
	public static final DefaultedKey<Byte> SKIN = new DefaultedKeyImpl<Byte>("skin", (byte) 0);
}
