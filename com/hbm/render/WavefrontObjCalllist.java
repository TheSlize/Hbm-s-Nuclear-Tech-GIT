package com.hbm.render;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.opengl.GL11;

import com.hbm.render.amlfrom1710.GroupObject;
import com.hbm.render.amlfrom1710.IModelCustom;
import com.hbm.render.amlfrom1710.Tessellator;
import com.hbm.render.amlfrom1710.WavefrontObject;

public class WavefrontObjCalllist implements IModelCustom {

	List<Pair<String, Integer>> nameToCallList = new ArrayList<>();
	
	public WavefrontObjCalllist(WavefrontObject obj) {
		Tessellator tes = Tessellator.instance;
		for(GroupObject g : obj.groupObjects){
			int list = GL11.glGenLists(1);
			GL11.glNewList(list, GL11.GL_COMPILE);
			tes.startDrawing(g.glDrawingMode);
			g.render(tes);
			tes.draw();
			GL11.glEndList();
			nameToCallList.add(Pair.of(g.name, list));
		}
		
	}
	
	public int getListForName(String name){
		for(Pair<String, Integer> p : nameToCallList){
			if(p.getLeft().equalsIgnoreCase(name)){
				return p.getRight();
			}
		}
		return 0;
	}

	@Override
	public String getType() {
		return "obj_list";
	}

	@Override
	public void renderAll() {
		for(Pair<String, Integer> p : nameToCallList)
			GL11.glCallList(p.getRight());
	}

	@Override
	public void renderOnly(String... groupNames) {
		for(Pair<String, Integer> p : nameToCallList){
			for(String name : groupNames){
				if(p.getLeft().equalsIgnoreCase(name)){
					GL11.glCallList(p.getRight());
					break;
				}
			}
		}
	}

	@Override
	public void renderPart(String partName) {
		for(Pair<String, Integer> p : nameToCallList){
			if(p.getLeft().equalsIgnoreCase(partName)){
				GL11.glCallList(p.getRight());
			}
		}
	}

	@Override
	public void renderAllExcept(String... excludedGroupNames) {
		for(Pair<String, Integer> p : nameToCallList){
			boolean skip = false;
			for(String name : excludedGroupNames){
				if(p.getLeft().equalsIgnoreCase(name)){
					skip = true;
					break;
				}
			}
			if(!skip){
				GL11.glCallList(p.getRight());
			}
		}
	}
}
