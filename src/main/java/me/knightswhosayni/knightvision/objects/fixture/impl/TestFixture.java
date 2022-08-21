package me.knightswhosayni.knightvision.objects.fixture.impl;

import me.knightswhosayni.knightvision.artnet.ArtnetUtil;
import me.knightswhosayni.knightvision.objects.fixture.DMXType;
import me.knightswhosayni.knightvision.objects.fixture.Fixture;

public class TestFixture extends Fixture {

	public TestFixture(ArtnetUtil artnet, int universe, int dmxAddr) {
		super(artnet, 7, universe, dmxAddr);
		dmxTypeHashMap.put(DMXType.RED,    0);
		dmxTypeHashMap.put(DMXType.GREEN,  1);
		dmxTypeHashMap.put(DMXType.BLUE,   2);
		dmxTypeHashMap.put(DMXType.STROBE, 4);
		dmxTypeHashMap.put(DMXType.DIMMER, 6);
	}

	@Override
	public void setDimmer(double value) {
		this.dmxData[dmxTypeHashMap.get(DMXType.DIMMER)] = (byte)(value*255);
	}

	@Override
	public void setRGB(double r, double g, double b) {
		this.dmxData[dmxTypeHashMap.get(DMXType.RED)] = (byte)(r*255);
		this.dmxData[dmxTypeHashMap.get(DMXType.GREEN)] = (byte)(g*255);
		this.dmxData[dmxTypeHashMap.get(DMXType.BLUE)] = (byte)(b*255);
	}

	@Override
	public void setStrobe(double value) {
		this.dmxData[dmxTypeHashMap.get(DMXType.STROBE)] = (byte)(value*255);
	}


}
