package me.knightswhosayni.knightvision.objects.cuelist;

import java.util.HashMap;
import java.util.List;

public class Cue {

	public HashMap<Integer, byte[]> universeDmxDataHashMap;

	public Cue(List<byte[]> dmxDataset, int[] universes) {
		universeDmxDataHashMap = new HashMap<>();
		int i = 0;
		for (byte[] bytes : dmxDataset) {
			universeDmxDataHashMap.put(universes[0], bytes);
		}
	}

}
