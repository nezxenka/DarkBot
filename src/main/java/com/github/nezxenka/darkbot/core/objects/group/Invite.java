package com.github.nezxenka.darkbot.core.objects.group;

import com.github.nezxenka.darkbot.core.itf.Updatable;
import com.github.nezxenka.darkbot.core.manager.HeroManager;
import eu.darkbot.api.game.group.GroupMember;

import static com.github.nezxenka.darkbot.Main.API;

public class Invite extends Updatable.Auto implements GroupMember.Invite {
    private final HeroManager hero;

    public PartialGroupMember inviter = new PartialGroupMember();
    public PartialGroupMember invited = new PartialGroupMember();
    public boolean incomming;
    public boolean valid;

    public Invite(HeroManager hero) {
        this.hero = hero;
    }

    @Override
    public void update() {
        if (address == 0) return;
        inviter.update(API.readLong(address + 0x20));
        invited.update(API.readLong(address + 0x28));
        valid = inviter.username != null && invited.username != null;
        incomming = inviter.id != hero.id && invited.id == hero.id;
    }

    @Override
    public eu.darkbot.api.game.group.PartialGroupMember getInviter() {
        return inviter;
    }

    @Override
    public eu.darkbot.api.game.group.PartialGroupMember getInvited() {
        return invited;
    }

    @Override
    public boolean isIncoming() {
        return incomming;
    }

    @Override
    public boolean isValid() {
        return valid;
    }
}
