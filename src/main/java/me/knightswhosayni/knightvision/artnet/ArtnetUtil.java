package me.knightswhosayni.knightvision.artnet;

import ch.bildspur.artnet.ArtNetClient;

import java.util.Arrays;

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
		System.out.println("artnet broadcasted; data: " + Arrays.toString(dmxData));
	}

	public void broadcast(int uni, byte[] tempData) {
		artnet.broadcastDmx(0, uni, tempData);
		System.out.println("artnet broadcasted; data: " + Arrays.toString(tempData));
	}

	// TODO implement unicast (necessary?)

}
