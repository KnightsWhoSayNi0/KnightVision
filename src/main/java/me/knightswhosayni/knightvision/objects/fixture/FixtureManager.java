package me.knightswhosayni.knightvision.objects.fixture;

import me.knightswhosayni.knightvision.artnet.ArtnetUtil;
import me.knightswhosayni.knightvision.objects.fixture.impl.TestFixture;

import java.util.ArrayList;
import java.util.List;

public class FixtureManager {

	public ArtnetUtil artnet;

	public List<Fixture> fixtureList;

	public FixtureManager(ArtnetUtil artnet) {
		this.artnet = artnet;

		fixtureList = new ArrayList<>();
		fixtureList.add(new TestFixture(artnet, 0, 0)); // TODO create patch command'
		fixtureList.add(new TestFixture(artnet, 0, 7));
	}

	public Fixture getFixture(int i) {
		return fixtureList.get(i);
	}

}
