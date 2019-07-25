package org.maxgamer.quickshop.Event;

import lombok.*;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.*;
import org.maxgamer.quickshop.Shop.DisplayItem;
import org.maxgamer.quickshop.Shop.DisplayType;
import org.maxgamer.quickshop.Shop.Shop;

/**
 * This event is called after DisplayItem removed
 */

public class ShopDisplayItemDespawnEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    @Getter
    @NotNull
    private Shop shop;
    @Getter
    @NotNull
    private ItemStack itemStack;
    @Getter
    @NotNull
    private DisplayType displayType;

    /**
     * This event is called before the shop display item created
     * @param shop Target shop
     * @param iStack Target itemstacck
     */
    @Deprecated
    public ShopDisplayItemDespawnEvent(@NotNull Shop shop, @NotNull ItemStack iStack) {
        this.shop = shop;
        this.itemStack = iStack;
        this.displayType = DisplayItem.getNowUsing();
    }

    /**
     * This event is called before the shop display item created
     * @param shop Target shop
     * @param iStack Target itemstacck
     * @param displayType The displayType
     */
    public ShopDisplayItemDespawnEvent(@NotNull Shop shop, @NotNull ItemStack iStack, @NotNull DisplayType displayType) {
        this.shop = shop;
        this.itemStack = iStack;
        this.displayType = displayType;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public HandlerList getHandlerList() {return handlers;}
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

}
