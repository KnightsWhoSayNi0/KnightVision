package me.knightswhosayni.knightvision.objects.fixture;

import me.knightswhosayni.knightvision.artnet.ArtnetUtil;

public abstract class Fixture {  // TODO implement .gdtf compliance

	public int channel;
	public byte[] dmxData;
	public int channelSize;
	public int universe;
	public int dmxAddr;
	public ArtnetUtil artnet;

	public Fixture(ArtnetUtil artnet, int channelSize, int universe, int dmxAddr) {
		this.artnet = artnet;
		this.channelSize = channelSize;
		this.universe = universe;
		this.dmxAddr = dmxAddr;
		dmxData = new byte[channelSize];
	}

	public void updateDMX() {
		int i = 0;
		for (byte b : this.dmxData) {
			artnet.dmxData[dmxAddr+i] = b;
			i++;
		}
		artnet.broadcast(universe);
	}

	// values passed as double ranging from 0 to 1 (multiplied by 255 and cast to byte in fixture extension)
	public abstract void setDimmer(double value);
	public abstract void setRGB(double r, double g, double b);
	public abstract void setStrobe(double value);

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public byte[] getDmxData() {
		return dmxData;
	}

	public void setDmxData(byte[] dmxData) {
		this.dmxData = dmxData;
	}

	public int getChannelSize() {
		return channelSize;
	}

	public void setChannelSize(int channelSize) {
		this.channelSize = channelSize;
	}

}
