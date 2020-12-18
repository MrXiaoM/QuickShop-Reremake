/*
 * This file is a part of project QuickShop, the name is ReflectFactory.java
 *  Copyright (C) PotatoCraft Studio and contributors
 *
 *  This program is free software: you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *  for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.maxgamer.quickshop.util;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

public class ReflectFactory {
    private static String cachedVersion = null;

    @NotNull
    public static String getServerVersion() {
        if (cachedVersion != null) {
            return cachedVersion;
        }
        try {
            Field consoleField = Bukkit.getServer().getClass().getDeclaredField("console");
            consoleField.setAccessible(true); // protected
            Object console = consoleField.get(Bukkit.getServer()); // dedicated server
            cachedVersion = String.valueOf(
                    console.getClass().getSuperclass().getMethod("getVersion").invoke(console));
            return cachedVersion;
        } catch (Exception e) {
            cachedVersion = "Unknown";
            return cachedVersion;
        }
    }

}
