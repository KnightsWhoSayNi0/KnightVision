package me.knightswhosayni.knightvision.artnet;

import ch.bildspur.artnet.ArtNetClient;

public class ArtnetUtil {

	public byte[] dmxData;
	ArtNetClient artnet;

	public ArtnetUtil(/* unicast addr? */) {
		dmxData = new byte[512];
		artnet = new ArtNetClient();
		artnet.start();
	}

	public void broadcast(int uni) {
		artnet.broadcastDmx(0, uni, dmxData);
	}

	public void broadcast(int uni, byte[] tempData) {
		if (tempData.length==512)
			artnet.broadcastDmx(0, uni, tempData);
		else
			artnet.broadcastDmx(0, uni, dmxData);
	}

	// TODO implement unicast (necessary?)

}
