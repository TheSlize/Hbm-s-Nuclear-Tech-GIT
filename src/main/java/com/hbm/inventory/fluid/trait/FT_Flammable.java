package com.hbm.inventory.fluid.trait;

import java.io.IOException;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import com.hbm.util.BobMathUtil;
import com.mojang.realmsclient.gui.ChatFormatting;

public class FT_Flammable extends FluidTrait {
	
	/** How much heat energy (usually translates into HE 1:1) 1000mB hold */
	private long energy;
	
	public FT_Flammable() { }
	
	public FT_Flammable(long energy) {
		this.energy = energy;
	}
	
	public long getHeatEnergy() {
		return this.energy;
	}
	
	@Override
	public void addInfo(List<String> info) {
		super.addInfo(info);
		
		info.add(ChatFormatting.YELLOW + "[Flammable]");
		
		if(energy > 0)
			info.add(ChatFormatting.YELLOW + "Provides " + ChatFormatting.RED + "" + BobMathUtil.getShortNumber(energy) + "TU " + ChatFormatting.YELLOW + "per bucket");
	}

	@Override
	public void serializeJSON(JsonWriter writer) throws IOException {
		writer.name("energy").value(energy);
	}
	
	@Override
	public void deserializeJSON(JsonObject obj) {
		this.energy = obj.get("energy").getAsLong();
	}
}
