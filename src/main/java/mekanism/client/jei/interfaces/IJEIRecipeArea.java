package mekanism.client.jei.interfaces;

import javax.annotation.Nullable;
import mekanism.client.gui.element.GuiElement;
import mekanism.common.Mekanism;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.util.ResourceLocation;

public interface IJEIRecipeArea<ELEMENT extends GuiElement> {

    /**
     * @return null if not an active recipe area, otherwise the category
     */
    @Nullable
    ResourceLocation[] getRecipeCategories();

    default boolean isActive() {
        return true;
    }

    ELEMENT jeiCategories(@Nullable ResourceLocation... recipeCategories);

    default ELEMENT jeiCategory(TileEntityMekanism tile) {
        return jeiCategories(tile.getBlockType().getRegistryName());
    }

    default ELEMENT jeiCrafting() {
        if (Mekanism.hooks.JEILoaded) {
            //return jeiCategories(VanillaRecipeCategoryUid.CRAFTING);//TODO - JEI
        }
        return jeiCategories((ResourceLocation) null);
    }
}