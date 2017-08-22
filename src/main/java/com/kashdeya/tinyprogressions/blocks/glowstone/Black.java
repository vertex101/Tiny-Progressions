package com.kashdeya.tinyprogressions.blocks.glowstone;

import java.util.Random;

import com.kashdeya.tinyprogressions.inits.TechItems;
import com.kashdeya.tinyprogressions.main.TinyProgressions;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Black extends Block
{
    public Black()
    {
        super(Material.GLASS);
        this.setHardness(0.3F);
        this.setSoundType(blockSoundType.GLASS);
        this.setLightLevel(1.0F);
        this.setCreativeTab(TinyProgressions.tabTP);
        this.setUnlocalizedName("black_glowstone");
    }
    
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	@Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
		return false;
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
    protected boolean canSilkHarvest()
    {
        return true;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return TechItems.black_dust;
    }

    public MapColor getMapColor(IBlockState state)
    {
        return MapColor.BLACK;
    }
}