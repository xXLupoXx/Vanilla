/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, SpoutDev <http://www.spout.org/>
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
package org.spout.vanilla.controller.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.spout.api.entity.Controller;
import org.spout.api.entity.Entity;
import org.spout.api.entity.type.ControllerType;
import org.spout.api.entity.type.EmptyConstructorControllerType;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.geo.cuboid.Region;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.scheduler.TaskPriority;
import org.spout.api.util.list.concurrent.ConcurrentList;

import org.spout.vanilla.VanillaPlugin;
import org.spout.vanilla.controller.VanillaController;
import org.spout.vanilla.material.block.ScheduleUpdated;

public class BlockUpdater implements Runnable {
	private static class Update {
		public Update(Block block, int delay) {
			this.block = block;
			this.counter = new AtomicInteger(delay);
		}

		public final Block block;
		public final AtomicInteger counter;
	}

	private static Map<Region, BlockUpdater> updaters = new HashMap<Region, BlockUpdater>();

	public static void remove(Region region) {
		synchronized (updaters) {
			updaters.remove(region);
			//do something? Saving?
		}
	}

	public static BlockUpdater get(Region region) {
		synchronized (updaters) {
			BlockUpdater u = updaters.get(region);
			if (u == null) {
				u = new BlockUpdater();
				region.getTaskManager().scheduleSyncRepeatingTask(VanillaPlugin.getInstance(), u, 1, 1, TaskPriority.HIGH);
				updaters.put(region, u);
			}
			return u;
		}
	}

	private ConcurrentList<Update> updates = new ConcurrentList<Update>();

	public static void schedule(Block block, int delay) {
		System.out.println("SCHEDULING: " + block.getX() + "/" + block.getY() + "/" + block.getZ());
		get(block.getRegion()).add(block, delay);
	}

	public void add(Block block, int delay) {
		this.updates.addDelayed(new Update(block, delay));
	}

	@Override
	public void run() {
		this.updates.sync();
		if (!this.updates.isEmpty()) {
			Iterator<Update> iter = this.updates.iterator();
			Update update;
			while (iter.hasNext()) {
				update = iter.next();
				if (update.counter.decrementAndGet() <= 0) {
					System.out.println("EXECUTE: " + update.block.getX() + "/" + update.block.getY() + "/" + update.block.getZ());
					iter.remove();
					//perform update
					BlockMaterial mat = update.block.getSubMaterial();
					if (mat instanceof ScheduleUpdated) {
						((ScheduleUpdated) mat).onDelayedUpdate(update.block);
					}
				}
			}
		}
	}
}
